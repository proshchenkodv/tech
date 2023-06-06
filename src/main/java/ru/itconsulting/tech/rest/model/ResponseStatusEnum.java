package ru.itconsulting.tech.rest.model;


public enum ResponseStatusEnum {
    RS_OK("0", 0, ""),
    RS_BAD_REQUEST("E_1_0", 1, "Пустое тело запроса"),
    RS_NO_DATA_FOUND("E_2", 2, "Данные не найдены"),
    RS_DATA_NOT_READY("E_3", 3, "Данные не готовы"),
    RS_INCORRECT_PARAM("E_4", 4, "Некорректные входные параметры"),
    RS_NOT_MODIFIED("E_5", 5, "Данные не изменены"),
    RS_FORBIDDEN("E_6", 6, "Доступ запрещен"),
    RS_DATA_MODIFIED("0", 7, "Данные сохранены"),
    RS_INTERNAL_ERROR("E_100", 100, "%s");


    private String status;
    private Integer code;
    private String errorMessage;

    ResponseStatusEnum(String status, Integer code, String errorMessage) {
        this.status = status;
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
