package sample.jersey.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * このクラスは、認証トークン付きリクエスト情報を定義する為の基底リクエストクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public abstract class AbstractAuthTokenRequest extends AbstractRequest {

	/** 認証トークン */
	@JsonProperty("authToken")
	private String authToken;

	/**
	 * コンストラクタ
	 */
	public AbstractAuthTokenRequest() {
		authToken = null;
	}

	/**
	 * 認証トークンを設定する。
	 * 
	 * @param token トークン
	 */
	public final void setAuthToken(final String token) {
		authToken = token;
	}

	/**
	 * 認証トークンを取得する。
	 * 
	 * @return トークン
	 */
	public final String getAuthToken() {
		return authToken;
	}
}
