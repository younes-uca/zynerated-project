package ma.zs.zyn.zynerator.security.common;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="1aaacb8f-7054-42df-936d-af8eed93a0cb";
    public static final long EXPIRATION=86400000;
    public static final String HEADER_PREFIX="Bearer ";
}
