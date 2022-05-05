package lostankit7.android.jetpackcompose

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val permissionsState = rememberMultiplePermissionsState(permissions = listOf(
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA,
            ))

            val lifeCycleOwner = LocalLifecycleOwner.current
            DisposableEffect(key1 = lifeCycleOwner, effect = {
                val observer = LifecycleEventObserver { _, event ->
                    if(event == Lifecycle.Event.ON_RESUME) {
                        permissionsState.launchMultiplePermissionRequest()
                    }
                }
                lifeCycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifeCycleOwner.lifecycle.removeObserver(observer)
                }
            })

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                permissionsState.permissions.forEach { permission ->
                    when (permission.permission) {
                        Manifest.permission.RECORD_AUDIO -> {
                            when {
                                permission.hasPermission -> {
                                    Text(text = "Camera permission accepted")
                                }
                                permission.shouldShowRationale -> {
                                    Text(text = "Camera permission is needed to access the camera")
                                }
                                permission.isPermanentlyDenied() -> {
                                    Text(text = "Camera permission permanently denied, You can enable in app settings")
                                }
                            }
                        }
                        Manifest.permission.CAMERA -> {
                            when {
                                permission.hasPermission -> {
                                    Text(text = "Audio permission accepted")
                                }
                                permission.shouldShowRationale -> {
                                    Text(text = "Audio permission is needed to play the music")
                                }
                                permission.isPermanentlyDenied() -> {
                                    Text(text = "Audio permission permanently denied, You can enable in app settings")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @ExperimentalPermissionsApi
    private fun PermissionState.isPermanentlyDenied() =
        !hasPermission && !shouldShowRationale

}