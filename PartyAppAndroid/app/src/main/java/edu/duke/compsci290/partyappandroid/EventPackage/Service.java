package edu.duke.compsci290.partyappandroid.EventPackage;

import java.util.List;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kennethkoch on 4/15/18.
 */

public interface Service {
    @Multipart
    @POST("/parties/")
    Call<ResponseBody> postImage(@Header("Authorization") String token,
                                 @Part("name") RequestBody name,
                                 @Part("description") RequestBody description,
                                 @Part("lat") RequestBody lat,
                                 @Part("lng") RequestBody lng,
                                 @Part("start_time") RequestBody start_time,
                                 @Part("end_time") RequestBody end_time,
                                 @Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("/invitations/")
    Call<ResponseBody> inviteUser(@Header("Authorization") String token,
                                  @Field("invitee_facebook_id") String fbid,
                                  @Field("party_id") String pid);

    @GET("/invitations/to-party/{pid}/")
    Single<List<UserInvitation>> getUsersInvited(@Header("Authorization") String token,
                                                     @Path("pid") String pid);


    @DELETE("/invitations/{uuid}/")
    Call<Response<Void>> removeInvitee(@Header("Authorization") String token,
                                         @Path("uuid") String uuid);

    @GET("parties/invited/me/")
    Single<List<PartyInvite>> getPartiesInvitedTo(@Header("Authorization") String token);

    @PUT("/invitations/{uuid}/rsvp/")
    Call<ResponseBody> rsvpUser(@Header("Authorization") String token,
                                @Path("uuid") String uuid);

    @PUT("/invitations/{uuid}/checkin/")
    Call<ResponseBody> checkinUser(@Header("Authorization") String token,
                                   @Path("uuid") String uuid);

    @GET("parties/hosted/me/")
    Single<List<PartyInvite>> getPartiesHosting(@Header("Authorization") String token);

    @DELETE("/parties/{pid}/")
    Call<Response<Void>> deleteParty(@Header("Authorization") String token,
                                     @Path("pid") String pid);

    @GET("/parties/{pid}/")
    Single<PartyInvite> getPartySpecifics(@Header("Authorization") String token,
                                                   @Path("pid") String pid);

    @GET("/invitations/to-party/{pid}/of-user/me")
    Call<UserInvitation> getMyInvitation(@Header("Authorization") String token,
                                                 @Path("pid") String pid);

    @GET("/invitations/to-party/{pid}")
    Single<List<UserInvitation>> getInvitationsToParty(@Header("Authorization") String token,
                                                       @Path("pid") String pid);

    @FormUrlEncoded
    @PUT("/parties/{pid}/bouncers/")
    Call<ResponseBody> addBouncerToParty(@Header("Authorization") String token,
                                         @Path("pid") String pid,
                                         @Field("bouncer_facebook_id") String facebook_id);

    @GET("/parties/bouncing/me/")
    Single<List<PartyInvite>> getPartiesBouncing(@Header("Authorization") String token);

    @GET("/parties/")
    Single<List<PartyInvite>> getNearbyParties(@Header("Authorization") String token,
                                               @Query("lat") String lat,
                                               @Query("lng") String lng);



}
