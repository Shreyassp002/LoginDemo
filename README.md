# Login Flow (UI)


![343057172-1825adb1-c81d-41ca-a09b-04c8405b3b46](https://github.com/user-attachments/assets/93298af2-96c1-4bc4-b16b-d125f67c4f79)




## Overview

Simple UI -> Splash - SignUp - Login - OTP - Home

## Dependencies

- Jetpack Compose
- Navigation Compose

```gradle
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //Compose navigation dependency
    implementation(libs.androidx.navigation.compose)
}
```

## Screenshots
Here are some screenshots showcasing the UI App:

![i](https://github.com/user-attachments/assets/75488053-4dfc-4cce-a762-d28123a6d76e)





## Resources
- [Navigation with Compose](https://developer.android.com/develop/ui/compose/navigation#kts)
- [Layouts in Compose](https://developer.android.com/develop/ui/compose/layouts)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose)
- [Material Design 3](https://m3.material.io/develop/android/jetpack-compose)
