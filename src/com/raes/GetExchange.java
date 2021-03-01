package com.raes;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetExchange {
    public ExChange getExchange(String q,String from, String to) {
        try {
            URL url = new URL("https://api.cambio.today/v1/quotes/" + from + "/" + to + "/json?quantity=" + q + "&key=7756|ZSVBvODEBS2cxDrpGbUs2G_HtZbuCc1f");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            System.out.println("loading...");
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            StringBuilder allOutput = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                allOutput.append(output);
            }
            JsonObject jsonObject = new JsonParser().parse(allOutput.toString()).getAsJsonObject();
            jsonObject = new JsonParser().parse(jsonObject.get("result").toString()).getAsJsonObject();
            conn.disconnect();
            ExChange exChange = new ExChange(jsonObject.get("source").toString(),jsonObject.get("target").toString(),jsonObject.get("value").toString(),jsonObject.get("updated").toString());
            return exChange;
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
    }
}

class Currency {
    public enum select {
        AED,    //Dírham de los Emiratos Árabes Unidos	01/12/2003	28/11/2020	17
        AFN,    //Afgani de Afganistán	01/01/0001	28/11/2020	2019
        ALL,    //Lek albanés	02/12/2003	27/11/2020	17
        AMD,    //Dram armenio	01/01/0001	27/11/2020	2019
        AOA,    //Angola kwanza	25/01/2014	27/11/2020	6
        ARS,    //Peso argentino	12/07/2001	28/11/2020	19
        AUD,    //Dólar australiano	16/05/2006	27/11/2020	14
        AWG,    //Florin Aruba	23/08/2004	28/11/2020	16
        AZN,    //Azerbaiyán manat	25/01/2014	27/11/2020	6
        BAM,    //Convertibles marca	25/01/2014	27/11/2020	6
        BBD,    //Dólar de Barbados	01/12/2003	28/11/2020	17
        BCH,    //Bitcoin Cash	01/01/0001	01/01/0001	0
        BDT,    //Bangladesh Taka	07/03/2002	28/11/2020	18
        BGN,    //Lev	07/03/2002	27/11/2020	18
        BHD,    //Dinar de Bahrein	07/03/2002	28/11/2020	18
        BIF,    //Franco de Burundi	24/01/2003	28/11/2020	17
        BMD,    //Dólar de Bermudas	07/03/2002	28/11/2020	18
        BND,    //Dólar de Brunei	07/03/2002	28/11/2020	18
        BOB,    //Boliviano	07/03/2002	28/11/2020	18
        BRL,    //Real brasileño	01/12/2003	28/11/2020	17
        BSD,    //Dólar de las Bahamas	01/12/2003	28/11/2020	17
        BTC,    //Bitcoin	01/01/0001	28/11/2020	2019
        BTN,    //Ngultrum Bhután	25/01/2014	27/11/2020	6
        BWP,    //Pula de Botswana	01/12/2003	27/11/2020	17
        BYN,    //Rublo bielorruso	01/01/0001	28/11/2020	2019
        BYR,    //Rublo bielorruso	25/01/2014	30/06/2016	2
        BZD,    //Dólar de Belice	01/12/2003	28/11/2020	17
        CAD,    //Dolar canadiense	17/09/2003	28/11/2020	17
        CDF,    //Franco congoleño	01/01/0001	28/11/2020	2019
        CHF,    //Franco suizo	17/09/2003	27/11/2020	17
        CLP,    //Peso chileno	01/12/2003	27/11/2020	17
        CNY,    //Chino Yuan	31/05/2001	28/11/2020	19
        COP,    //Peso colombiano	30/05/2001	28/11/2020	19
        CRC,    //Costa Rica Colón	01/12/2003	28/11/2020	17
        CUP,    //Peso cubano	01/12/2003	28/11/2020	17
        CVE,    //Escudo caboverdiano	01/12/2003	28/11/2020	17
        CZK,    //Corona checa	01/12/2003	28/11/2020	17
        DJF,    //Franco de Yibuti	01/12/2003	28/11/2020	17
        DKK,    //Danesa	01/12/2003	27/11/2020	17
        DOP,    //Peso dominicano	01/12/2003	28/11/2020	17
        DZD,    //Dinar argelino	01/12/2003	28/11/2020	17
        ECS,    //Sucre ecuatoriano	10/12/2014	24/02/2017	3
        EGP,    //Libra egipcia	29/05/2001	28/11/2020	19
        ERN,    //Nakfa Eritrea	25/01/2014	28/11/2020	6
        ETB,    //Birr etíope	01/12/2003	27/11/2020	17
        ETH,    //Etereum	01/01/0001	28/11/2020	2019
        EUR,    //Euro	01/12/2003	27/11/2020	17
        FJD,    //Dólar fiyiano	21/06/2006	27/11/2020	14
        FKP,    //Libra de las Islas Malvinas	25/01/2014	03/10/2020	6
        GBP,    //Libra esterlina	01/12/2003	27/11/2020	17
        GEL,    //Lari georgiano	25/01/2014	27/11/2020	6
        GHS,    //Cedi de Ghana	11/07/2007	28/11/2020	13
        GIP,    //Libra de Gibraltar	25/01/2014	27/11/2020	6
        GMD,    //Dalasi de Gambia	01/12/2003	27/11/2020	17
        GNF,    //Guinea franco	01/12/2003	28/11/2020	17
        GTQ,    //Guatemala quetzal	01/12/2003	28/11/2020	17
        GYD,    //Dólar de Guyana	31/03/2005	28/11/2020	15
        HKD,    //Dolar de Hong Kong	16/07/2001	28/11/2020	19
        HNL,    //Lempira hondureño	01/12/2003	28/11/2020	17
        HRK,    //Kuna croata	07/03/2002	27/11/2020	18
        HTG,    //Gourde haitiano	01/12/2003	28/11/2020	17
        HUF,    //Florín húngaro	01/12/2003	28/11/2020	17
        IDR,    //Rupia Indonesia	26/06/2001	28/11/2020	19
        ILS,    //Shekel israelí	01/12/2003	28/11/2020	17
        INR,    //Rupia india	01/12/2003	28/11/2020	17
        IQD,    //Dinar iraquí	21/01/2004	28/11/2020	16
        IRR,    //Rial iraní	01/12/2003	28/11/2020	17
        ISK,    //Corona islandesa	01/12/2003	27/11/2020	17
        JMD,    //Dólar de Jamaica	01/12/2003	28/11/2020	17
        JOD,    //Dinar jordano	01/12/2003	28/11/2020	17
        JPY,    //Yen japonés	01/01/1999	27/11/2020	21
        KES,    //Chelín keniano	01/12/2003	28/11/2020	17
        KGS,    //Som kirguís	25/01/2014	26/11/2020	6
        KHR,    //Riel camboyano	01/12/2003	28/11/2020	17
        KRW,    //Corea del Sur ganó	01/12/2003	28/11/2020	17
        KWD,    //Dinar kuwaití	01/12/2003	28/11/2020	17
        KYD,    //Dólar de las Islas Caimán	07/03/2002	28/11/2020	18
        KZT,    //Tenge kazajo	01/12/2003	28/11/2020	17
        LAK,    //Kip lao	01/12/2003	28/11/2020	17
        LBP,    //Libra libanesa	01/12/2003	28/11/2020	17
        LKR,    //Rupia de Sri Lanka	01/12/2003	27/11/2020	17
        LRD,    //Dólar liberiano	31/03/2010	28/11/2020	10
        LSL,    //Loti de Lesotho	01/12/2003	27/11/2020	17
        LTC,    //Litecoin	01/01/0001	28/11/2020	2019
        LYD,    //Dinar libio	01/12/2003	28/11/2020	17
        MAD,    //Dirham marroquí	01/12/2003	28/11/2020	17
        MDL,    //Leu moldavo	01/12/2003	28/11/2020	17
        MGA,    //Ariary malgache	03/01/2005	27/11/2020	15
        MKD,    //Denar macedonio	01/12/2003	28/11/2020	17
        MMK,    //Kyat birmano	01/12/2003	28/11/2020	17
        MNT,    //Mongolia Tugrik	25/01/2014	28/11/2020	6
        MOP,    //Pataca de Macao	01/12/2003	28/11/2020	17
        MRO,    //Mauritania ouguiya	01/12/2003	28/01/2019	16
        MUR,    //Rupia de Mauricio	01/12/2003	28/11/2020	17
        MVR,    //Rufiyaa de Maldivas	25/08/2004	28/11/2020	16
        MWK,    //Kwacha de Malawi	01/12/2003	28/11/2020	17
        MXN,    //Peso mejicano	01/12/2003	28/11/2020	17
        MYR,    //Ringgit malayo	01/12/2003	28/11/2020	17
        NAD,    //Dólar de Namibia	01/12/2003	28/11/2020	17
        NGN,    //Naira Nigeria	01/12/2003	27/11/2020	17
        NIO,    //Córdoba	01/12/2003	27/11/2020	17
        NOK,    //Corona noruega	16/07/2001	27/11/2020	19
        NPR,    //Rupia de Nepal	01/12/2003	27/11/2020	17
        NZD,    //Dolar de Nueva Zelanda	01/12/2003	27/11/2020	17
        OMR,    //Rial de Omán	01/12/2003	28/11/2020	17
        PAB,    //Balboa panameño	01/12/2003	28/11/2020	17
        PEN,    //Sol peruano	31/05/2001	28/11/2020	19
        PGK,    //Papua Nueva Guinea Kina	01/12/2003	27/11/2020	17
        PHP,    //Peso filipino	01/12/2003	28/11/2020	17
        PKR,    //Rupia paquistaní	08/03/2002	28/11/2020	18
        PLN,    //Zloty polaco	01/12/2003	28/11/2020	17
        PYG,    //Guaraní paraguayo	01/12/2003	28/11/2020	17
        QAR,    //Rial qatarí	01/12/2003	28/11/2020	17
        RON,    //Leu rumano	27/06/2005	27/11/2020	15
        RSD,    //Dinar serbio	05/02/2007	27/11/2020	13
        RUB,    //Rublo ruso	01/12/2003	28/11/2020	17
        RWF,    //Ruanda franco	01/12/2003	28/11/2020	17
        SAR,    //Riyal saudí	01/12/2003	27/11/2020	17
        SBD,    //Dólar de las Islas Salomón	25/01/2014	27/11/2020	6
        SCR,    //Rupia de Seychelles	01/12/2003	28/11/2020	17
        SEK,    //Corona sueca	16/07/2001	27/11/2020	19
        SGD,    //Dolar de Singapur	01/12/2003	27/11/2020	17
        SHP,    //Saint Helena Libra	17/03/2005	03/10/2020	15
        SLL,    //Leone de Sierra Leona	25/08/2004	28/11/2020	16
        SOS,    //Chelín somalí	01/12/2003	27/11/2020	17
        SRD,    //Dólar de Surinam	25/01/2014	28/11/2020	6
        STD,    //Santo Tomé y Príncipe dobra	01/12/2003	28/01/2019	16
        SVC,    //Colón salvadoreño	24/08/2004	28/11/2020	16
        SYP,    //Libra Siria	01/12/2003	28/11/2020	17
        SZL,    //Swazilandia Lilangeni	01/12/2003	28/11/2020	17
        THB,    //Baht tailandés	01/12/2003	28/11/2020	17
        TND,    //Dinar tunecino	01/12/2003	28/11/2020	17
        TOP,    //Pa'anga tongano	25/01/2014	28/11/2020	6
        TRY,    //Lira turca	03/01/2005	28/11/2020	15
        TTD,    //Trinidad	01/12/2003	28/11/2020	17
        TWD,    //Dólar de Taiwán	24/03/2004	28/11/2020	16
        TZS,    //Shilling tanzano	01/12/2003	28/11/2020	17
        UAH,    //Hryvnia Ucrania	07/03/2002	28/11/2020	18
        UGX,    //Shilling de Uganda	07/03/2002	28/11/2020	18
        USD,    //Dólar de los Estados Unidos	01/01/1970	28/11/2020	50
        UYU,    //Peso uruguayo	07/03/2002	28/11/2020	18
        UZS,    //Som uzbekistani	11/08/2005	27/11/2020	15
        VND,    //Dong vietnamita	01/12/2003	28/11/2020	17
        VUV,    //Vanuatu Vatu	07/03/2002	28/11/2020	18
        WST,    //Samoan Tala	25/01/2014	28/11/2020	6
        YER,    //Rial yemení	24/08/2004	27/11/2020	16
        ZAR,    //Rand sudafricano	01/12/2003	28/11/2020	17
    }
}
