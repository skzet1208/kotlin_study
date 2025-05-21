package com.example.apisample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var result by mutableStateOf("")

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    result = "ログイン成功: ${response.body()?.token}"
                } else {
                    result = "エラー: ${response.code()}"
                }
            } catch (e: Exception) {
                result = "失敗: ${e.message}"
            }
        }
    }
}