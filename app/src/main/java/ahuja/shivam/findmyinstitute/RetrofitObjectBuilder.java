package ahuja.shivam.findmyinstitute;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by root on 22/4/17.
 */

public class RetrofitObjectBuilder {
    static String url ="https://findmyinstitute.000webhostapp.com/";
    static Retrofit retrofit =new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    static RetrofitApiInterface retrofitApiInterface=retrofit.create(RetrofitApiInterface.class);
    public static RetrofitApiInterface makeRetrofitApiInterfaceObject()
    {
        return retrofitApiInterface;
    }
}
