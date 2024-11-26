package com.example.demoapp.models

import android.content.Context
import com.example.demoapp.R

data class Hobby(var title: String)

object Supplier {
    fun getHobbies(context: Context): List<Hobby>
    {
        return listOf(
            Hobby(context.getString(R.string.hobby_one)),
            Hobby(context.getString(R.string.hobby_two)),
            Hobby(context.getString(R.string.hobby_three)),
            Hobby(context.getString(R.string.hobby_four)),
            Hobby(context.getString(R.string.hobby_five)),
            Hobby(context.getString(R.string.hobby_six)),
            Hobby(context.getString(R.string.hobby_seven)),
            Hobby(context.getString(R.string.hobby_one)),
            Hobby(context.getString(R.string.hobby_two)),
            Hobby(context.getString(R.string.hobby_three)),
            Hobby(context.getString(R.string.hobby_four)),
            Hobby(context.getString(R.string.hobby_five)),
            Hobby(context.getString(R.string.hobby_six)),
            Hobby(context.getString(R.string.hobby_seven)),
            Hobby(context.getString(R.string.hobby_one)),
            Hobby(context.getString(R.string.hobby_two)),
            Hobby(context.getString(R.string.hobby_three)),
            Hobby(context.getString(R.string.hobby_four)),
            Hobby(context.getString(R.string.hobby_five)),
            Hobby(context.getString(R.string.hobby_six)),
            Hobby(context.getString(R.string.hobby_seven)),
            Hobby(context.getString(R.string.hobby_one)),
            Hobby(context.getString(R.string.hobby_two)),
            Hobby(context.getString(R.string.hobby_three)),
            Hobby(context.getString(R.string.hobby_four)),
            Hobby(context.getString(R.string.hobby_five)),
            Hobby(context.getString(R.string.hobby_six)),
            Hobby(context.getString(R.string.hobby_seven)),
            Hobby(context.getString(R.string.hobby_one)),
            Hobby(context.getString(R.string.hobby_two)),
            Hobby(context.getString(R.string.hobby_three)),
            Hobby(context.getString(R.string.hobby_four)),
            Hobby(context.getString(R.string.hobby_five)),
            Hobby(context.getString(R.string.hobby_six)),
            Hobby(context.getString(R.string.hobby_seven)),
        )
    }
}