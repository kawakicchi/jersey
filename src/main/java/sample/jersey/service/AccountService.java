package sample.jersey.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.azkfw.business.BusinessServiceException;
import org.azkfw.util.MapUtility;

import sample.jersey.logic.AccountManager;
import sample.jersey.request.AbstractAuthTokenRequest;
import sample.jersey.request.AbstractRequest;
import sample.jersey.response.AbstractResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

@Path("account")
/**
 * このクラスは、アカウント機能を提供するサービスクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class AccountService extends AbstractBaseService {

	public AccountService() {
		super(AccountService.class);
	}

	@POST
	@Path("login")
	/**
	 * ログイン機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse login(final LoginRequest req) throws Exception {
		LoginResponse res = new LoginResponse();

		AccountManager manager = (AccountManager) getLogic("AccountManager");
		Map<String, Object> result = manager.login(req.getMailAddress(), req.getPassword());
		if (!result.isEmpty()) {
			setSuccess(res);
			res.setAuthToken((String) result.get("authToken"));
			res.setName((String) result.get("name"));
		} else {
			setError(res, 1, "Error");
		}

		return res;
	}

	@POST
	@Path("logout")
	/**
	 * ログアウト機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LogoutResponse logout(final LogoutRequest req) throws Exception {
		LogoutResponse res = new LogoutResponse();

		AccountManager manager = (AccountManager) getLogic("AccountManager");
		boolean result = manager.logout(req.getAuthToken());
		if (result) {
			setSuccess(res);
		} else {
			setError(res, 1, "Error");
		}
		
		return res;
	}

	@POST
	@Path("regist")
	/**
	 * アカウント登録機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegistResponse regist(final RegistRequest req) throws Exception {
		RegistResponse res = new RegistResponse();

		AccountManager manager = (AccountManager) getLogic("AccountManager");
		Map<String, Object> result = manager.regist(req.getName(), req.getMailAddress(), req.getPassword());
		if (MapUtility.isNotEmpty(result)) {
			// TODO: メール送信
			String token = (String) result.get("token");
			setSuccess(res);
		}

		return res;
	}

	@GET
	@Path("activate/{token:[0-9a-zA-Z]{32}}")
	/**
	 * アカウントアクティベート機能
	 * 
	 * @param token アクティベートトークン
	 * @return HTML文字列
	 */
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML)
	public String activate(@PathParam("token") final String token) throws Exception {
		String html = "";

		return html;
	}

	/**
	 * このクラスは、ログインリクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class LoginRequest extends AbstractRequest {

		/** メールアドレス */
		@JsonProperty("mail")
		private String mailAddress;

		/** パスワード */
		@JsonProperty("pass")
		private String password;

		/**
		 * コンストラクタ
		 */
		public LoginRequest() {
			mailAddress = null;
			password = null;
		}

		/**
		 * メールアドレスを設定する。
		 * 
		 * @param address メールアドレス
		 */
		public void setMailAddress(final String address) {
			mailAddress = address;
		}

		/**
		 * メールアドレスを取得する。
		 * 
		 * @return メールアドレス
		 */
		public String getMailAddress() {
			return mailAddress;
		}

		/**
		 * パスワードを設定する。
		 * 
		 * @param password パスワード
		 */
		public void setPassword(final String password) {
			this.password = password;
		}

		/**
		 * パスワードを取得する。
		 * 
		 * @return パスワード
		 */
		public String getPassword() {
			return password;
		}
	}

	/**
	 * このクラスは、ログインレスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class LoginResponse extends AbstractResponse {

		/** 認証トークン */
		@JsonProperty("authToken")
		private String authToken;

		/** 名前 */
		@JsonProperty("name")
		private String name;

		/**
		 * コンストラクタ
		 */
		public LoginResponse() {
			authToken = null;
			name = null;
		}

		/**
		 * 認証トークンを設定する。
		 * 
		 * @param token トークン
		 */
		public void setAuthToken(final String token) {
			authToken = token;
		}

		/**
		 * 認証トークンを取得する。
		 * 
		 * @return トークン
		 */
		public String getAuthToken() {
			return authToken;
		}

		/**
		 * 名前を設定する。
		 * 
		 * @param name 名前
		 */
		public void setName(final String name) {
			this.name = name;
		}

		/**
		 * 名前を取得する。
		 * 
		 * @return 名前
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * このクラスは、ログアウトリクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class LogoutRequest extends AbstractAuthTokenRequest {

	}

	/**
	 * このクラスは、ログアウトレスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class LogoutResponse extends AbstractResponse {

	}

	/**
	 * このクラスは、アカウント登録リクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class RegistRequest extends AbstractRequest {

		/** 名前 */
		@JsonProperty("name")
		private String name;

		/** メールアドレス */
		@JsonProperty("mail")
		private String mailAddress;

		/** パスワード */
		@JsonProperty("pass")
		private String password;

		/** パスワード(確認) */
		@JsonProperty("confirm")
		private String confirm;

		/**
		 * コンストラクタ
		 */
		public RegistRequest() {
			name = null;
			mailAddress = null;
			password = null;
			confirm = null;
		}

		/**
		 * 名前を設定する。
		 * 
		 * @param name 名前
		 */
		public void setName(final String name) {
			this.name = name;
		}

		/**
		 * 名前を取得する。
		 * 
		 * @return 名前
		 */
		public String getName() {
			return name;
		}

		/**
		 * メールアドレスを設定する。
		 * 
		 * @param address メールアドレス
		 */
		public void setMailAddress(final String address) {
			mailAddress = address;
		}

		/**
		 * メールアドレスを取得する。
		 * 
		 * @return メールアドレス
		 */
		public String getMailAddress() {
			return mailAddress;
		}

		/**
		 * パスワードを設定する。
		 * 
		 * @param password パスワード
		 */
		public void setPassword(final String password) {
			this.password = password;
		}

		/**
		 * パスワードを取得する。
		 * 
		 * @return パスワード
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * パスワード(確認)を設定する。
		 * 
		 * @param password パスワード
		 */
		public void setConfirm(final String password) {
			confirm = password;
		}

		/**
		 * パスワード(確認)を取得する。
		 * 
		 * @return パスワード
		 */
		public String getConfirm() {
			return confirm;
		}
	}

	/**
	 * このクラスは、アカウント登録レスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class RegistResponse extends AbstractResponse {

	}

}
