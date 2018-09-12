package Model;

import javax.xml.bind.annotation.XmlRootElement;

import com.opencsv.bean.CsvBindByName;

@XmlRootElement
public class Graffiti {

	@CsvBindByName(column = "Exchange", required = false)
	String Exchange;
	
	@CsvBindByName(column = "Security Type", required = false)
	String Security_Type;
	
	@CsvBindByName(column = "Symbol", required = false)
	String Symbol;
	
	@CsvBindByName(column = "Root symbol (for opt", required = false)
	String Root_Symbol;
	
	@CsvBindByName(column = "Listed Currency", required = false)
	String Listed_Currency;
	
	@CsvBindByName(column = "Company name", required = false)
	String Company_Name;
	
	@CsvBindByName(column = "Additional company n", required = false)
	String Additional_Company_Name;
	
	@CsvBindByName(column = "ISIN code", required = false)
	String ISIN_Code;
	
	@CsvBindByName(column = "Contract name", required = false)
	String Contract_Name;
	
	@CsvBindByName(column = "Local instrument cod", required = false)
	String Local_Instrument_Code;
	
	@CsvBindByName(column = "Country", required = false)
	String Country;
	
	@CsvBindByName(column = "Market specific secu", required = false)
    String	Market_specific_secu;
	
	@CsvBindByName(column = "Market specific segm", required = false)
    String Market_specific_segm;
    
	@CsvBindByName(column = "Listing market for t", required = false)
    String Listing_Market_For_t;
	
	@CsvBindByName(column = "Original exchange co", required = false)
    String Original_Exchange_co;
	
	@CsvBindByName(column = "Exchange code", required = false)
    String Exchange_Code;
	
	@CsvBindByName(column = "QS Symbol Suffix", required = false)
    String QS_Symbol_suffix;
	
	@CsvBindByName(column = "Sedol", required = false)
    String Sedol;
    
	@CsvBindByName(column = "MS Performance ID", required = false)
	String MS_Performance_Id;
	
	@CsvBindByName(column = "Global ID investment", required = false)
	String Global_investement_id;
	
	@CsvBindByName(column = "MS Listing Exchange", required = false)
	String MS_Listing_exchange;
	
	@CsvBindByName(column = "MS Extended Support", required = false)
	String MS_Extended_Support;
	
	@CsvBindByName(column = "Morningstar ID", required = false)
	String MorningStar_id;
	
	@CsvBindByName(column = "S3076", required = false)
	String S3076;
	
	@CsvBindByName(column = "Expiry date (Julian)", required = false)
	String ExpiryDate;
	
	@CsvBindByName(column = "Call ('C') or Put ('", required = false)
	String Call_or_Put;
	
	@CsvBindByName(column = "Strike price", required = false)
	String Strike_Price;
	
	@CsvBindByName(column = "Traded Currency", required = false)
	String Traded_Currency;
	
	
	public String getExchange() {
		return Exchange;
	}
	public void setExchange(String exchange) {
		Exchange = exchange;
	}
	public String getSecurity_Type() {
		return Security_Type;
	}
	public void setSecurity_Type(String security_Type) {
		Security_Type = security_Type;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	public String getRoot_Symbol() {
		return Root_Symbol;
	}
	public void setRoot_Symbol(String root_Symbol) {
		Root_Symbol = root_Symbol;
	}
	public String getListed_Currency() {
		return Listed_Currency;
	}
	public void setListed_Currency(String listed_Currency) {
		Listed_Currency = listed_Currency;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public String getAdditional_Company_Name() {
		return Additional_Company_Name;
	}
	public void setAdditional_Company_Name(String additional_Company_Name) {
		Additional_Company_Name = additional_Company_Name;
	}
	public String getISIN_Code() {
		return ISIN_Code;
	}
	public void setISIN_Code(String iSIN_Code) {
		ISIN_Code = iSIN_Code;
	}
	public String getContract_Name() {
		return Contract_Name;
	}
	public void setContract_Name(String contract_Name) {
		Contract_Name = contract_Name;
	}
	public String getLocal_Instrument_Code() {
		return Local_Instrument_Code;
	}
	public void setLocal_Instrument_Code(String local_Instrument_Code) {
		Local_Instrument_Code = local_Instrument_Code;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getMarket_specific_secu() {
		return Market_specific_secu;
	}
	public void setMarket_specific_secu(String market_specific_secu) {
		Market_specific_secu = market_specific_secu;
	}
	public String getMarket_specific_segm() {
		return Market_specific_segm;
	}
	public void setMarket_specific_segm(String market_specific_segm) {
		Market_specific_segm = market_specific_segm;
	}
	public String getListing_Market_For_t() {
		return Listing_Market_For_t;
	}
	public void setListing_Market_For_t(String listing_Market_For_t) {
		Listing_Market_For_t = listing_Market_For_t;
	}
	public String getOriginal_Exchange_co() {
		return Original_Exchange_co;
	}
	public void setOriginal_Exchange_co(String original_Exchange_co) {
		Original_Exchange_co = original_Exchange_co;
	}
	public String getExchange_Code() {
		return Exchange_Code;
	}
	public void setExchange_Code(String exchange_Code) {
		Exchange_Code = exchange_Code;
	}
	public String getQS_Symbol_suffix() {
		return QS_Symbol_suffix;
	}
	public void setQS_Symbol_suffix(String qS_Symbol_suffix) {
		QS_Symbol_suffix = qS_Symbol_suffix;
	}
	public String getSedol() {
		return Sedol;
	}
	public void setSedol(String sedol) {
		Sedol = sedol;
	}
	public String getMS_Performance_Id() {
		return MS_Performance_Id;
	}
	public void setMS_Performance_Id(String mS_Performance_Id) {
		MS_Performance_Id = mS_Performance_Id;
	}
	public String getGlobal_investement_id() {
		return Global_investement_id;
	}
	public void setGlobal_investement_id(String global_investement_id) {
		Global_investement_id = global_investement_id;
	}
	public String getMS_Listing_exchange() {
		return MS_Listing_exchange;
	}
	public void setMS_Listing_exchange(String mS_Listing_exchange) {
		MS_Listing_exchange = mS_Listing_exchange;
	}
	public String getMS_Extended_Support() {
		return MS_Extended_Support;
	}
	public void setMS_Extended_Support(String mS_Extended_Support) {
		MS_Extended_Support = mS_Extended_Support;
	}
	public String getMorningStar_id() {
		return MorningStar_id;
	}
	public void setMorningStar_id(String morningStar_id) {
		MorningStar_id = morningStar_id;
	}
	public String getS3076() {
		return S3076;
	}
	public void setS3076(String s3076) {
		S3076 = s3076;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	public String getCall_or_Put() {
		return Call_or_Put;
	}
	public void setCall_or_Put(String call_or_Put) {
		Call_or_Put = call_or_Put;
	}
	public String getStrike_Price() {
		return Strike_Price;
	}
	public void setStrike_Price(String strike_Price) {
		Strike_Price = strike_Price;
	}
	public String getTraded_Currency() {
		return Traded_Currency;
	}
	public void setTraded_Currency(String traded_Currency) {
		Traded_Currency = traded_Currency;
	}
}
