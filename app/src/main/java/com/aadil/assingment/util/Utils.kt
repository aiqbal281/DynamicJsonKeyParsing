package com.aadil.assingment.util

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class Utils {

    companion object{
        fun getString(`in`: InputStream): String {
            val `is` = InputStreamReader(`in`)
            val sb = StringBuilder()
            val br = BufferedReader(`is`)
            try {
                var read: String? = br.readLine()
                while (read != null) {
                    sb.append(read)
                    read = br.readLine()
                }
            } catch (e: Exception) {
//            Log.e("JsonConverter", "ERROR WHILE PARSING RESPONSE TO STRING :: " + e.message)
            } finally {
                try {
                    `is`.close()
                    br.close()
                } catch (ignored: Exception) {
                }

            }
            System.gc()
            return sb.toString()
        }

    }
}