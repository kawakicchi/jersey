package sample.jersey.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * このクラスは、レスポンス情報を定義する為の基底レスポンスクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public abstract class AbstractResponse implements Response {

	/** 結果コード */
	@JsonProperty("resultCode")
	private int resultCode;

	/** エラーコード */
	@JsonProperty("errorCode")
	private Integer errorCode;

	/** エラーメッセージ */
	@JsonProperty("errorMessage")
	private String errorMessage;

	/**
	 * コンストラクタ
	 */
	public AbstractResponse() {
		resultCode = 0;
		errorCode = null;
		errorMessage = null;
	}

	@Override
	public final void setResultCode(final int code) {
		resultCode = code;
	}

	@Override
	public final int getResultCode() {
		return resultCode;
	}

	@Override
	public final void setErrorCode(final Integer code) {
		errorCode = code;
	}

	@Override
	public final Integer getErrorCode() {
		return errorCode;
	}

	@Override
	public final void setErrorMessage(final String message) {
		errorMessage = message;
	}

	@Override
	public final String getErrorMessage() {
		return errorMessage;
	}
}
