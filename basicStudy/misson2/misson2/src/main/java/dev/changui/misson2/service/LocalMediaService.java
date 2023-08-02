package dev.changui.misson2.service;

import dev.changui.misson2.model.MediaDescriptorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;


@Service
public class LocalMediaService implements  MediaService{
    private static final Logger logger = LoggerFactory.getLogger(LocalMediaService.class);
    private final String basePath = "./media";
    @Override
    public MediaDescriptorDto saveFile(MultipartFile file) {
        return this.saveToDir(file);
    }

    @Override
    public Collection<MediaDescriptorDto> saveFileBulk(MultipartFile[] files) {
        Collection<MediaDescriptorDto> resultList = new ArrayList<>();
        for(MultipartFile file : files){
            resultList.add(this.saveFile(file));
        }
        return resultList;
    }

    @Override
    public byte[] getFileAsBytes(String resourcePath) {
        try{
            return Files.readAllBytes(Path.of(basePath, resourcePath));
        }catch (IOException e){

            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }

    private MediaDescriptorDto saveToDir(MultipartFile file){
        MediaDescriptorDto DescriptorDto = new MediaDescriptorDto();
        DescriptorDto.setStatus(200);
        DescriptorDto.setOriginalName(file.getOriginalFilename());
        try {
            LocalDateTime now = LocalDateTime.now();
            String targetDir = Path.of(
                    basePath,
                    now.format(DateTimeFormatter.BASIC_ISO_DATE)).toString();
            String newFileName =
                    now.format(DateTimeFormatter.ofPattern("HHmmss"))
                    +"_"
                    +file.getOriginalFilename();
            File dirNow = new File(targetDir);
            if(!dirNow.exists()) dirNow.mkdir();

            file.transferTo(Path.of(
                    targetDir,
                    newFileName)
            );
            DescriptorDto.setResourcePath(Path.of(
                    targetDir,
                    newFileName).toString().substring(1)
            );
            return DescriptorDto;
        }catch(IOException e){
            logger.error(e.getMessage());
            DescriptorDto.setMessage("Failed");
            DescriptorDto.setStatus(500);
            return DescriptorDto;
        }
    }
}
