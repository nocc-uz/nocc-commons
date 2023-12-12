package uz.kyuu.backend.base;


public class GlobalVar {

    private final static ThreadLocal<String> H_REQUEST_ID = ThreadLocal.withInitial(String::new);
    private final static ThreadLocal<String> USER_UUID = ThreadLocal.withInitial(String::new);

    public static String getUserUUID() {
        return GlobalVar.USER_UUID.get();
    }

    public static void setUserUuid(String userUuid) {
        GlobalVar.USER_UUID.set(userUuid);
    }


    public static String getRequestId() {
        return GlobalVar.H_REQUEST_ID.get();
    }

    public static void setRequestId(String requestId) {
        GlobalVar.H_REQUEST_ID.set(requestId);
    }

}
