package dev.changui.jpa;

import dev.changui.jpa.exception.BaseException;
import dev.changui.jpa.exception.ErrorResponseDto;
import dev.changui.jpa.exception.PostNotInBoardException;
import dev.changui.jpa.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("except")
public class ExceptTestController {


    @GetMapping("{id}")
    public ErrorResponseDto throwEception(@PathVariable int id){
        switch(id){
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

   /* // 현재 컨트롤러 내부에서 발생하는 모든 BaseException에 대해서 처리를 해준다.
    @ExceptionHandler(BaseException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST) 이렇게도 받아올 수 있다.
    public ErrorResponseDto handleBaseException(
            BaseException exception, HttpServletResponse response){
        return new ErrorResponseDto(exception.getMessage());
    }*/




}
