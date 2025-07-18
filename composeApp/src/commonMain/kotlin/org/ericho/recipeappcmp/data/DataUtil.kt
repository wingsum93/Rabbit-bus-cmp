package org.ericho.recipeappcmp.data

import org.ericho.recipeappcmp.data.model.ApiResponse

inline fun <R> runCatching(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        Result.failure(e)
    }
}

suspend fun <T> safeApiCall(apiCall: suspend () -> ApiResponse<T>): T {
    val response = apiCall()

    // 空數據直接 throw
    when (response.data) {
        is List<*> -> {
            if ((response.data as List<*>).isEmpty()) {
                throw NoSuchElementException("Empty list returned")
            }
        }

        else -> {
            if (response.data == null) {
                throw NoSuchElementException("Empty object returned")
            }
        }
    }
    return response.data
}