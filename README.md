安卓简单动画集合
## Step 1

#### Gradle
```groovy
dependencies {
        compile 'com.nineoldandroids:library:2.4.0'
        compile 'com.daimajia.easing:library:1.0.1@aar'
        compile 'com.daimajia.androidanimations:library:1.1.3@aar'


#### Eclipse

Download the following jars, and copy them into your `libs` directory.

-   [`NineOldAndroid-2.4.0`](https://github.com/daimajia/AndroidViewAnimations/releases/download/v1.0.6/NineOldAndroid-2.4.0.jar)
-   [`AndroidEasingFunctions-1.0.0`](https://github.com/daimajia/AndroidViewAnimations/releases/download/v1.0.6/AndroidEasingFunctions-1.0.0.jar)
-   [`AndroidViewAnimations-1.1.3`](https://github.com/daimajia/AndroidViewAnimations/releases/download/v1.1.3/AndroidViewAnimations-1.1.3.jar)

## Step 2

Just like play Yo-yo.

```java
YoYo.with(Techniques.Tada)
    .duration(700)
    .playOn(findViewById(R.id.edit_area));
```

### Effects
#### Attension
`Flash`, `Pulse`, `RubberBand`, `Shake`, `Swing`, `Wobble`, `Bounce`, `Tada`, `StandUp`, `Wave`

#### Special
`Hinge`, `RollIn`, `RollOut`,`Landing`,`TakingOff`,`DropOut`

#### Bounce
`BounceIn`, `BounceInDown`, `BounceInLeft`, `BounceInRight`, `BounceInUp`

#### Fade
`FadeIn`, `FadeInUp`, `FadeInDown`, `FadeInLeft`, `FadeInRight`

`FadeOut`, `FadeOutDown`, `FadeOutLeft`, `FadeOutRight`, `FadeOutUp`

#### Flip
`FlipInX`, `FlipOutX`, `FlipOutY`

#### Rotate
`RotateIn`, `RotateInDownLeft`, `RotateInDownRight`, `RotateInUpLeft`, `RotateInUpRight`

`RotateOut`, `RotateOutDownLeft`, `RotateOutDownRight`, `RotateOutUpLeft`, `RotateOutUpRight`

#### Slide
`SlideInLeft`, `SlideInRight`, `SlideInUp`, `SlideInDown`

`SlideOutLeft`, `SlideOutRight`, `SlideOutUp`, `SlideOutDown`

#### Zoom
`ZoomIn`, `ZoomInDown`, `ZoomInLeft`, `ZoomInRight`, `ZoomInUp`

`ZoomOut`, `ZoomOutDown`, `ZoomOutLeft`, `ZoomOutRight`, `ZoomOutUp`

Welcome contribute your amazing animation effect. :-D

#Thanks

- [AFViewShaker](https://github.com/ArtFeel/AFViewShaker)
- [Animate.css](https://github.com/daneden/animate.css)

#About me

A student in mainland China. 

Welcome to [offer me an internship](mailto:daimajia@gmail.com).
If you have any new idea about this project, feel free to [contact me](mailto:daimajia@gmail.com).
