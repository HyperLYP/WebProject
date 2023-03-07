package com.tsu.mslyp.common;

/**
 * 统一整个项目中Ajax请求json返回的结果
 * @param <T>
 */
public class ResultEntity<T> {
    public static final int SUCCESS = 200;
    public static final int FAILED = 500;
    // 用来封装当前请求处理的结果是成功还是失败
    private int code;
    // 请求处理失败时返回的错误消息！
    private String message;
    // 要返回的数据
    private T data;
    //    分页时候使用的总条目数，可以添加上
    private Long count;

    /**
     * 请求处理成功且不需要返回数据时使用的工具方法
     *
     * @return
     */
    public static <T> ResultEntity<T> success() {
        return new ResultEntity<T>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     *
     * @param data 要返回的数据
     * @return
     */
    public static <Type> ResultEntity<Type> success(Type data) {
        return new ResultEntity<Type>(SUCCESS, null, data);
    }
    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     *
     * @param data 要返回的数据
     * @return
     */
    public static <Type> ResultEntity<Type> success(Type data,long totalCount) {
        return new ResultEntity<Type>(SUCCESS, null, data,totalCount);
    }

    /**
     * 请求处理失败后使用的工具方法
     *
     * @param message 失败的错误消息
     * @return
     */
    public static <Type> ResultEntity<Type> fail(String message) {
        return new ResultEntity<Type>(FAILED, message, null);
    }

    /**
     * 请求处理失败后使用的工具方法
     *
     * @param code    添加规定好的错误代码指令！
     * @param message 返回的错误消息！
     * @param <Type>  泛型
     * @return
     */
    public static <Type> ResultEntity<Type> fail(int code, String message) {
        return new ResultEntity<Type>(code, message, null);
    }

    private ResultEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResultEntity(int code, String message, T data, Long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private ResultEntity() {
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}