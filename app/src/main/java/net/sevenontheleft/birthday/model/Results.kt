package net.sevenontheleft.birthday.model

import com.google.gson.annotations.SerializedName

class Results {
    @SerializedName("results")
    var birthdays = mutableListOf<Birthday>()

    // at some later stage we may want to store the "info" data as well but for the moment we don't need it
}