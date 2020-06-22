package cn.easybuy.utils;

import java.io.Serializable;
import java.util.Map;


public class ReturnResult implements Serializable{

    private int status;
    private Object data;
    private String message="操作成功";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回成功状态
     *
     */
    public static  ReturnResult success(String message, Map<String, Object> map) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(Constants.ReturnResult.SUCCESS);
        returnResult.setMessage(message);
        returnResult.setData(map);
        return returnResult;
    }
    /**
     * 返回成功状态
     *
     */
    public static  ReturnResult success(String message) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(Constants.ReturnResult.SUCCESS);
        returnResult.setMessage(message);
        return returnResult;
    }
    /**
     * 返回失败状态
     */
    public static  ReturnResult err(String message){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setStatus(Constants.ReturnResult.FAIL);
        returnResult.setMessage(message);
        return returnResult;
    }
    /**
     * 返回成功状态
     * @param obj
     */
    public ReturnResult returnSuccess(Object obj){
        this.status=Constants.ReturnResult.SUCCESS;
        this.data=obj;
        return this;
    }
    /**
     * 返回默认成功状态
     */
    public ReturnResult returnSuccess(){
        this.status=Constants.ReturnResult.SUCCESS;
        return this;
    }
    /**
     * 返回失败状态
     * @param message
     */
    public ReturnResult returnFail(String message){
        this.status=Constants.ReturnResult.FAIL;
        this.message=message;
        return this;
    }

    public ReturnResult(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ReturnResult(Object data) {
        this.status=Constants.ReturnResult.SUCCESS;
        this.data = data;
    }

    public ReturnResult(){

    }
}
