@file:OptIn(ExperimentalPermissionsApi::class)

package de.tu.textscanner.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import de.tu.textscanner.ui.camera.CameraScreen
import de.tu.textscanner.ui.no_permission.NoPermissionScreen

@Composable
fun MainScreen() {

    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    MainContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )
}

@Composable
private fun MainContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
) {

    if (hasPermission) {
        CameraScreen()
    } else {
        NoPermissionScreen(onRequestPermission)
    }
}

@Preview
@Composable
private fun Preview_MainContent() {
    MainContent(
        hasPermission = true,
        onRequestPermission = {}
    )
}
