package de.sample.gitrepos.di.module;

import java.io.File;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

import de.sample.gitrepos.BuildConfig;
import de.sample.gitrepos.client.ApiConstants;
import de.sample.gitrepos.client.service.RepoApi;
import de.sample.gitrepos.di.qualifier.ClientCache;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

import retrofit2.converter.gson.GsonConverterFactory;

import rx.schedulers.Schedulers;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) //
                   .setDateFormat(ApiConstants.DATE_TIME_FORMAT)                        //
                   .excludeFieldsWithoutExposeAnnotation();

        return gsonBuilder.create();
    }

    @Singleton
    @Provides
    @ClientCache
    File provideCacheFile(final Application context) {
        return new File(context.getCacheDir(), ApiConstants.OKCLIENT_DISK_CACHE_NAME);
    }

    @Provides
    @Singleton
    Cache provideCacheNew(@ClientCache final File cacheDir) {
        return new Cache(cacheDir, ApiConstants.DISK_CACHE_SIZE);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return
            new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                                                                    : HttpLoggingInterceptor.Level.NONE);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final Cache cache, final HttpLoggingInterceptor httpLoggingInterceptor) {
        return
            new OkHttpClient.Builder().cache(cache)                                                                   //
                                      .connectTimeout(ApiConstants.NETWORK_CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS) //
                                      .addInterceptor(httpLoggingInterceptor)                                         //
                                      .readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)                  //
                                      .writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)                //
                                      .build();
    }

    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    @Singleton
    GsonConverterFactory provideRxGsonConverterFactory(final Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final OkHttpClient okHttpClient, final GsonConverterFactory gsonConverterFactory,
            final RxJavaCallAdapterFactory rxCallAdapterFactory) {
        return
            new Retrofit.Builder().addConverterFactory(gsonConverterFactory)   //
                                  .addCallAdapterFactory(rxCallAdapterFactory) //
                                  .baseUrl(ApiConstants.BASE_URL)              //
                                  .client(okHttpClient)                        //
                                  .build();
    }

    @Provides
    @Singleton
    RepoApi provideRepoApiService(final Retrofit retrofit) {
        return retrofit.create(RepoApi.class);
    }
}
