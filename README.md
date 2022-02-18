
# EasyingOrientation

[![](https://jitpack.io/v/ldh-star/EasyingOrientation.svg)](https://jitpack.io/#ldh-star/EasyingOrientation) ![](https://img.shields.io/badge/author-ldh-orange.svg) ![](https://img.shields.io/hexpm/l/plug.svg)


## Start

#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

#### Step 2. Add the dependency

```gradle
dependencies {
	implementation 'com.github.ldh-star:EasyingOrientation:$last_version'
}
```

#### Step 3. Usage

##### In manifest
```xml

<activity
    ...
    android:screenOrientation="portrait"
    .../>

```

##### In your activity
```kotlin

listenOnOrientationChanged { state ->
    when (state.orientation) {
        0 -> 
        90 ->  
        180 ->
        270 ->
    }
    
    when (state) {
        is OrientationState.PortraitReverse ->
        is OrientationState.Landscape ->
    }
}

```

##### or 
```kotlin

EasyingOrition.listenOnOrientationChanged(context, lifecycleOwner, angleThreshold) {
    
}

```


## Licenses

```
 Copyright 2022 original author or authors.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```