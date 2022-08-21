package luiz.augusto.userhandlingforanimelistproject.exceptions;

public class TokenExpiredException extends RuntimeException{
    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}
