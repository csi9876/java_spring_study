package hello.login.web;

public class SessionConst {
    public static final String LOGIN_MEMBER = "loginMember";
}

/*
>>> 변수로 사용하기 위해 지정하는 것이므로 밑에 처럼 하는 게 더 좋다
public abstrace class SessionConst {
    public static final String LOGIN_MEMBER = "loginMember";
}

public interface SessionConst {
    String LOGIN_MEMBER = "loginMember";
}
*/
