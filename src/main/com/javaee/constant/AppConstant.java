package com.javaee.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppConstant {
    public  static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    public  static  final String USER ="root";
    public  static  final String PASSWORD ="fahim";
    public  static  final String URL ="jdbc:mysql://127.0.0.1:3306/javaee";
}
