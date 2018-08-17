package quick.kural.quickstart.Retrofit;

import android.content.Context;
import android.preference.PreferenceManager;

import quick.kural.quickstart.Activitys.SplashActivity;
import quick.kural.quickstart.Utils.SharedPrefUtils;

/**
 * Created by kural mughil selvam on 08-10-2017.
 */

public interface ApiInterface {



  /*@Multipart
  @POST("user_signup")
  Call<signupStatus> rf_signUp(@Header(header) String header_value, @Part("first_name") String first_name,
                               @Part("last_name") String last_name,
                               @Part("email") String email,
                               @Part("password") String password,
                               @Part("phone") String phone,
                               @Part("zipcode") String zipcode);

  @Multipart
  @POST("user_login_process")
  Call<LoginResp> rf_signIn(@Header(header) String header_value, @Part("login_email") String login_email,
                            @Part("login_password") String login_password);


  @Multipart
  @POST("social_login_process")
  Call<LoginResp> rf_signIn_social(@Header(header) String header_value, @Part("email") String login_email);
  //https://stackoverflow.com/questions/39953457/how-to-upload-image-file-in-retrofit-2


  @Multipart
  @POST("upload_profile_picture")
  Call<UpdateAccountResp> rf_uploadPic(@Header(header) String header_value, @Part("email") String email,
                                       @Part MultipartBody.Part upload_profile_picture);*/

}