#Nifty

Nifty is an android library project with the goal of becoming a general purpose
collection of enhancements. Currently, it's main attraction is the ability to 
specify typefaces from your /assets directory in XML and in styles.

##Usage

First off, you need to know how to use a [library project](http://developer.android.com/guide/developing/projects/index.html#LibraryProjects)

Once you've got that done, it's as simple as using NiftyButton or NiftyTextView
where you would ordinarily use a Button or TextView. These classes are fully 
compatible and when you need to preview in the layout editor, you can just do
a search/replace on them (to Button and TextView, respectively)

###In a style

####Example Style:

    <style name="MyStyle" parent="@android:style/Theme">
            <item name="typeface">my_font_that_is_in_assets.ttf</item>
    </style>

####Example XML:

    <com.tomdignan.nifty.NiftyTextView
        android:id="@+id/hello"
        style="@style/MyStyle"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />    

###As an attribute in your layout

    <com.tomdignan.nifty.NiftyTextView
        xmlns:nifty="http://schemas.tomdignan.com/nifty"
        nifty:typeface="my_font_that_is_in_assets.ttf"
        android:id="@+id/hello"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:text="@string/hello_world" />  
