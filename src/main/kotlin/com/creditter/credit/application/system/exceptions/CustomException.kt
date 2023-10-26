package com.creditter.credit.application.system.exceptions

data class CustomException(override val message: String?) : RuntimeException(message) {

}
