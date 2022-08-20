package common.util;


/**
 * 规范ajax请求返回json的统一格式，分布式架构中也可以用来调用各个模块时返回统一类型
 */
public class ResultUtil<T> {
    //用来封装当前请求的结果是成功还是失败
    private String result;

    //请求失败时，返回的错误信息
    private String message;

    //要返回的数据对象
    private T data;

    public ResultUtil() {
    }

    public ResultUtil(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    /**
     * 返回操作结果为成功，携带数据
     * @param data
     * @return
     */
    public static <T>  ResultUtil<T> successWithData(T data) {
        return new ResultUtil(SUCCESS, NO_MESSAGE, data);
    }
    /**
     * 返回操作结果为失败，不带数据
     * @param message
     * @return
     */
    public static <T>  ResultUtil<T> failed(String message) {
        return new ResultUtil(FAILED, message, null);
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

