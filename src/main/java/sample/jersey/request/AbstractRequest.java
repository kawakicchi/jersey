package sample.jersey.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * このクラスは、リクエスト情報を定義する為の基底リクエストクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public abstract class AbstractRequest {

	/** クライアントバージョン */
	@JsonProperty("clientVersion")
	private String clientVersion;

	/**
	 * コンストラクタ
	 */
	public AbstractRequest() {
		clientVersion = null;
	}

	/**
	 * クライアントバージョンを設定する。
	 * 
	 * @param version バージョン
	 */
	public final void setClientVersion(final String version) {
		clientVersion = version;
	}

	/**
	 * クライアントバージョンを取得する。
	 * 
	 * @return バージョン
	 */
	public final String getClientVersion() {
		return clientVersion;
	}
}
