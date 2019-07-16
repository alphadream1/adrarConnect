package com.adrar.adrarconnect.data.utils;

//
// Created by FERRARIS Philippe on 27/06/2019 for adrarConnect.
//

import com.adrar.adrarconnect.data.model.AccueilBean;
import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.model.UserBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceWebServices {

    @GET(Constants.URL_ACCUEIL)
    Call<AccueilBean> getAccueilData();

    @POST(Constants.URL_SIGNIN)
    Call<UserBean> postUserSignin(@Body UserBean userBean);

    @POST(Constants.URL_LOGIN)
    Call<UserBean> postUserLogin(@Body UserBean userBean);

    @POST(Constants.URL_CANDIDAT_UPDATE_DETAILS)
    Call<UserBean> postUserUpdateDetails(@Body UserBean userBean);

    @POST(Constants.URL_CANDIDAT_UPDATE_DOCUMENT)
    Call<UserBean> postUserDocument(@Body DocumentsBean documentsBean);

    @POST(Constants.URL_INFOCOL_INSCRIPTION)
    Call<UserBean> postUserInfoco(@Body InfoCollectiveBean infoCollectiveBean);

    @POST(Constants.URL_INFOCOL_MODIFICATION)
    Call<UserBean> postUserUpdateInfoco(@Body InfoCollectiveBean infoCollectiveBean);

    @POST(Constants.URL_INFOCOL_ANNULATION)
    Call<UserBean> postUserDeleteInfoco(@Body InfoCollectiveBean infoCollectiveBean);
}
