package de.sample.gitrepos.client;

public final class ApiConstants {

    public static final String BASE_URL = "https://api.github.com/";
    public static final String BASE_REPO_USER = "realm";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final int DISK_CACHE_SIZE = 150 * 1024 * 1024; // 150MB
    public static final String OKCLIENT_DISK_CACHE_NAME = "http-cache";

    public static final long NETWORK_CONNECTION_TIMEOUT = 20 * 1000L; // 20 sec
    public static final long READ_TIMEOUT = 15 * 1000L;               // 15 sec
    public static final long WRITE_TIMEOUT = 15 * 1000L;              // 15 sec
}
