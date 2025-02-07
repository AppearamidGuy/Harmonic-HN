package com.simon.harmonichackernews.utils;

import static com.simon.harmonichackernews.utils.Utils.GLOBAL_SHARED_PREFERENCES_KEY;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class SettingsUtils {


    public static Set<Integer> readIntSetFromSharedPreferences(Context ctx, String key) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        Set<String> emptyBackup = new HashSet<>();
        Set<String> stringSet = sharedPref.getStringSet(key, emptyBackup);

        Set<Integer> intSet = new HashSet<>(stringSet.size());
        for (String string : stringSet) {
            intSet.add(Integer.parseInt(string));
        }
        return intSet;
    }

    public static void saveIntSetToSharedPreferences(Context ctx, String key, Set<Integer> set) {
        Set<String> stringSet = new HashSet<>(set.size());

        for (Integer integer : set) {
            stringSet.add(integer.toString());
        }

        saveStringSetToSharedPreferences(ctx, key, stringSet);
    }

    public static Set<String> readStringSetFromSharedPreferences(Context ctx, String key) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        Set<String> emptyBackup = new HashSet<>();
        return sharedPref.getStringSet(key, emptyBackup);
    }

    public static void saveStringSetToSharedPreferences(Context ctx, String key, Set<String> set) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putStringSet(key, set).apply();
    }

    public static void saveStringToSharedPreferences(Context ctx, String key, String text) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(key, text).apply();
    }

    public static String readStringFromSharedPreferences(Context ctx, String key) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        return sharedPref.getString(key, null);
    }

    public static String readStringFromSharedPreferences(Context ctx, String key, String fallback) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(GLOBAL_SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
        return sharedPref.getString(key, fallback);
    }

    public static boolean shouldShowPoints(Context ctx) {
        return getBooleanPref("pref_show_points", true, ctx);
    }

    public static boolean shouldUseCompactView(Context ctx) {
        return getBooleanPref("pref_compact_view", false, ctx);
    }

    public static boolean shouldShowThumbnails(Context ctx) {
        return getBooleanPref("pref_thumbnails", true, ctx);
    }

    public static boolean shouldCollapseParent(Context ctx) {
        return getBooleanPref("pref_collapse_parent", false, ctx);
    }

    public static boolean shouldShowIndex(Context ctx) {
        return getBooleanPref("pref_show_index", false, ctx);
    }

    public static boolean shouldShowNavigationButtons(Context ctx) {
        return getBooleanPref("pref_scroll_navigation", false, ctx);
    }

    public static boolean shouldHideJobs(Context ctx) {
        return getBooleanPref("pref_hide_jobs", false, ctx);
    }

    public static int getPreferredHotness(Context ctx) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return Integer.parseInt(prefs.getString("pref_hotness", "-1"));
    }

    public static String getPreferredFont(Context ctx) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString("pref_font", "productsans");
    }

    public static boolean shouldUseExternalBrowser(Context ctx) {
        return getBooleanPref("pref_external_browser", false, ctx);
    }

    public static boolean shouldUseMonochromeCommentDepthIndicators(Context ctx) {
        return getBooleanPref("pref_monochrome_comment_depth", false, ctx);
    }

    public static boolean shouldUseIntegratedWebView(Context ctx) {
        return getBooleanPref("pref_webview", true, ctx);
    }

    public static boolean shouldEnableFoldableSupport(Context ctx) {
        return getBooleanPref("pref_foldable_support", false, ctx);
    }

    public static String shouldPreloadWebView(Context ctx) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString("pref_preload_webview", "never");
    }

    public static boolean shouldMatchWebViewTheme(Context ctx) {
        return getBooleanPref("pref_webview_match_theme", false, ctx);
    }

    public static boolean shouldBlockAds(Context ctx) {
        return getBooleanPref("pref_webview_adblock", false, ctx);
    }

    public static boolean shouldDisableWebviewSwipeBack(Context ctx) {
        return getBooleanPref("pref_webview_disable_swipeback", true, ctx);
    }

    public static boolean shouldDisableCommentsSwipeBack(Context ctx) {
        return getBooleanPref("pref_comments_disable_swipeback", false, ctx);
    }

    public static boolean shouldShowTopLevelDepthIndicator(Context ctx) {
        return getBooleanPref("pref_top_level_thread_indicators", false, ctx);
    }

    public static boolean shouldAlwaysOpenComments(Context ctx) {
        return getBooleanPref("pref_always_open_comments", false, ctx);
    }

    public static boolean shouldShowWebviewExpandButton(Context ctx) {
        return getBooleanPref("pref_webview_show_expand", true, ctx);
    }

    public static boolean shouldUseWebViewDeviceBack(Context ctx) {
        return getBooleanPref("pref_webview_device_back", false, ctx);
    }

    public static boolean shouldUseCompactHeader(Context ctx) {
        return getBooleanPref("pref_compact_header", false, ctx);
    }

    public static boolean shouldUseLeftAlign(Context ctx) {
        return getBooleanPref("pref_left_align", false, ctx);
    }

    public static boolean shouldUseTransparentStatusBar(Context ctx) {
        return getBooleanPref("pref_transparent_status_bar", false, ctx);
    }

    public static boolean shouldUseSpecialNighttimeTheme(Context ctx) {
        return getBooleanPref("pref_special_nighttime", false, ctx);
    }

    public static boolean shouldUseCommentsAnimation(Context ctx) {
        return getBooleanPref("pref_comments_animation", true, ctx);
    }

    public static boolean shouldUseAlgolia(Context ctx) {
        return getBooleanPref("pref_algolia_api", true, ctx);
    }

    public static boolean getBooleanPref(String key, boolean backup, Context ctx) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getBoolean(key, backup);
    }

    public static int getPreferredCommentTextSize(Context ctx) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(ctx).getString("pref_comment_text_size", "15"));
    }

}
