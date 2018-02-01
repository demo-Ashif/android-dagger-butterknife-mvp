/*
 * Copyright 2018 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.daggerbutterknifemvp.ui.example_2

import android.support.v7.app.AppCompatActivity
import com.vestrel00.daggerbutterknifemvp.inject.PerActivity
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivityModule
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_a.view.Example2AFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_a.view.Example2AFragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view.Example2BFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view.Example2BFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Provides example 2 activity dependencies.
 */
@Module(includes = [BaseActivityModule::class])
abstract class Example2ActivityModule {

    /**
     * Provides the injector for the [Example2AFragment], which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [Example2AFragmentModule::class])
    abstract fun example2AFragmentInjector(): Example2AFragment

    /**
     * Provides the injector for the [Example2BFragment], which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [Example2BFragmentModule::class])
    abstract fun example2BFragmentInjector(): Example2BFragment

    /**
     * As per the contract specified in [BaseActivityModule]; "This must be included in all
     * activity modules, which must provide a concrete implementation of [AppCompatActivity]."
     *
     * @param example2Activity the example 2 activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract fun appCompatActivity(example2Activity: Example2Activity): AppCompatActivity
}
