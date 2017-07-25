package ahuja.shivam.findmyinstitute;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by shivam on 17/4/17.
 */

public interface RetrofitApiInterface {
     //to fetch institute list

    @GET("institute/institute_list.php")
    Call<List<DataPojoClass>> getinstituteList();

    @GET("institute/delhi_institute_list.php")
    Call<List<DataPojoClass>> getDelhiInstituteList();

    @GET("institute/chennai_institute_list.php")
    Call<List<DataPojoClass>> getChennaiInstituteList();

    @GET("institute/hyderabad_institute_list.php")
    Call<List<DataPojoClass>> getHyderabadInstituteList();

    @GET("institute/banglore_institute_list.php")
    Call<List<DataPojoClass>> getBangloreInstituteList();
}
