package ru.itconsulting.tech.rest.utils;

import org.springframework.data.domain.Page;
import ru.itconsulting.tech.rest.payload.response.ResponseResult;

import java.util.List;

public class ControllerUtil {
    public static final long TOTAL_DEFAULT_1 = 1L;

    public static <T> ResponseResult<T> createResponseResult(Page<T> dto) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setData(dto.getContent());
        responseResult.setTotal(dto.getTotalElements());
        responseResult.setTotalPages(dto.getTotalPages());
        responseResult.setCurrentPage(dto.getNumber());
        return responseResult;
    }

    public static <T> ResponseResult<T> createResponseResult(List<T> dto) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setData(dto);
        responseResult.setTotal((long) dto.size());
        return responseResult;
    }

    public static <T> ResponseResult<T> createResponseResult(T dto) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setData(dto);
        responseResult.setTotal(TOTAL_DEFAULT_1);
        return responseResult;
    }

    public static ResponseResult createResponseHollowResult() {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setTotal(TOTAL_DEFAULT_1);
        return responseResult;
    }
}
