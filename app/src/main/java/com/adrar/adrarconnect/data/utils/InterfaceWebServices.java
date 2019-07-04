package com.adrar.adrarconnect.data.utils;

//
// Created by FERRARIS Philippe on 27/06/2019 for adrarConnect.
//

import com.adrar.adrarconnect.data.model.AccueilBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceWebServices {

    @GET(Constants.URL_ACCUEIL)
    Call<AccueilBean> getAccueilData();

    @POST(Constants.URL_SIGNIN)
    Call<UserBean> postUserSignin(@Body UserBean userBean);

}
