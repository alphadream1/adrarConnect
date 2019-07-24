package com.adrar.adrarconnect.utils

import android.content.Context.MODE_PRIVATE
import com.adrar.adrarconnect.data.model.AccueilBean
import com.adrar.adrarconnect.data.staticData.Constants

private const val SPFileName = "SPFileName.xml"


private const val SAVE_ACCUEIL_KEY = "SAVE_ACCUEIL_KEY"

//SharedPreferenceUtilsKt.saveAcceuil(accueilBean);
fun saveAcceuil(data: AccueilBean) =
        MyApplication.context.getSharedPreferences(SPFileName, MODE_PRIVATE).edit().putString(SAVE_ACCUEIL_KEY, Constants.GSON.toJson(data)).apply()


//AccueilBean accueilBean = SharedPreferenceUtilsKt.getAccueil();
fun getAccueil(): AccueilBean? {

    val json: String? = MyApplication.context.getSharedPreferences(SPFileName, MODE_PRIVATE).getString(SAVE_ACCUEIL_KEY, null)

    return if (json != null) {
        Constants.GSON.fromJson(json, AccueilBean::class.java)
    } else {
        null
    }
}