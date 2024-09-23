package com.prudhvir3ddy.flipper_demo

import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader

object FlipperUtil {

    private val networkFlipperPlugin = NetworkFlipperPlugin()

    fun setupFlipper(application: FlipperDemoApplication) {
        SoLoader.init(application, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(application)) {
            AndroidFlipperClient.getInstance(application).apply {
                addPlugin(
                    InspectorFlipperPlugin(
                        application,
                        DescriptorMapping.withDefaults()
                    )
                )
                addPlugin(networkFlipperPlugin)
            }.start()
        }
    }


    fun getFlipperNetworkInterceptor() = FlipperOkhttpInterceptor(networkFlipperPlugin, true)
}