package com.arkademy.arkademytraining.week4

import com.google.gson.annotations.SerializedName

/**
 * Created by adrianfikri on 2020-02-13.
 */
open class BaseApiResponse {

    @SerializedName("status")
    var status: String = ""
}