const data = [{
	stockExchange: "FOREX",
	code : "FOREX",
	symbols: "EUR/USD;GBP/USD;USD/JPY;USD/CHF;AUD/USD"
},
{
	stockExchange: "Commodities Trading",
	code: "COMMODITIES",
	symbols: "GC;SI;CO;CL;CR"
},

{
	stockExchange: "Crypto",
	code: "CRYPTO",
	symbols: "BTC;ETH;XRP;BCH;LTC;DOGE"
},
{
	stockExchange: "Futures",
	code: "FUTURES",
	symbols: "GCQ18;CLU18;SPU18;E6Q18;ZQQ18"
},
{
	stockExchange: "Bonds",
	code: "BONDS",
	symbols: "US10YBY;US30YBY;GER10YBY;UK10YBY;US10YTN"
},
{
	stockExchange: "USA",
	code: "USA",
	symbols: "AAPL;MSFT;GOOG;FB;ORCL"
},
{
	stockExchange: "USA OTC",
	code: "OTCMKTS",
	symbols: "DTEGY;SSDOY;SKYAY;CIOXY;WMMVY"
},
{
	stockExchange: "USA OTC BB",
	code: "OTCBB",
	symbols: "SNGX;NEPH;CRCUF;INVS;NAOV"
},
{
	stockExchange: "Japan",
	code: "TSE",
	symbols: "7203;9437;9432;7974;2914"
},
{
	stockExchange: "Hong Kong",
	code: "HKSE",
	symbols: "01398;00941;00857;00939;00700"
}, 
{
	stockExchange: "China (Shanghai)",
	code: "SSE",
	symbols: "601398;601857;601939;601628;601988"
},
{
	stockExchange: "China (Shenzhen)",
	code: "SZSE",
	symbols: "200725;000100;000709;200625;002024"
},
{
	stockExchange: "Germany (Frankfurt)",
	code: "FWB",
	symbols: "SIE;BTG4;SAP;BAYN;DTE"
},
{
	stockExchange: "Germany (XETRA)",
	code: "XETRA",
	symbols: "SIE;ALV;SAP;BAYN;DTE"
},
{
	stockExchange: "Netherlands",
	code: "AEX",
	symbols: "RDSA;UNA;HEIA;INGA;MT"
},
{
	stockExchange: "Belgium",
	code: "BEX",
	symbols: "ABI;SOLB;AGS;KBC;ABO"
},
{
	stockExchange: "France",
	code: "PEX",
	symbols: "ALAUP"
}, 
{
	stockExchange: "Portugal",
	code: "LEX",
	symbols: "BCP;EDP;BPI;JMT;GALP"
},
{
	stockExchange: "Canada",
	code: "TSX",
	symbols: "RY;K;FM;BNP;ABX"
},
{
	stockExchange: "Canada (Venture)",
	code: "TSXV",
	symbols: "SVI;GOM;ID;LEXI;KNT"
},
{
	stockExchange: "Canada CSE",
	code: "CSE",
	symbols: "TER;AHG;IAN;CRZ;MDM"
},
{
	stockExchange: "Canada NEO",
	code: "NEO",
	symbols: "HALO;MGW;GGO;ETHC;MLC"
},
{
	stockExchange: "Switzerland",
	code: "SIX",
	symbols: "SCHN;NWRN;UHRN;TEMN;LISN"
},
{
	stockExchange: "South Korea",
	code: "KRX",
	symbols: "005930;066570;005490;021240;015760"
},
{
	stockExchange: "South Korea (Kosdaq)",
	code: "kosdaq",
	symbols: "052710;026960;035720;051500;084990"
},
{
	stockExchange: "Sweden",
	code: "OMXS",
	symbols: "ERIC-A;HM-B;ATCO-A;INVE-A;NDA-SEK"
},
{
	stockExchange: "Denmark",
	code: "OMXC",
	symbols: "NOVO-B;MAERSK-A;DANSKE;CARL-B;VWS"
},
{
	stockExchange: "Finland",
	code: "OMXH",
	symbols: "NOKIA;METSA;KNEBV;ELISA;TLT1V"
},
{
	stockExchange: "Iceland",
	code: "OMXI",
	symbols: "ICEAIR;OSSRU;MARL;EIM;BNORDIK"
},
{
	stockExchange: "India (BSE)",
	code: "BSE",
	symbols: "532540;532454;500325;500370;519475"
}, 
{
	stockExchange: "India (NSE)",
	code: "NSE",
	symbols: "SBIN;LT;ICICIBANK;RELIANCE;HINDALCO"
}, 
{
	stockExchange: "Taiwain",
	code: "TWSE",
	symbols: "2498;2330;3605;2317;6505"
}, 
{
	stockExchange: "Spain",
	code: "BME",
	symbols: "SAN;TEF;BBVA;IBE;ELE"
}, 
{
	stockExchange: "South Africa",
	code: "JSE",
	symbols: "NPN;HAR;BTI;SBK;GLN"
}, 
{
	stockExchange: "Brazil",
	code: "Bovespa",
	symbols: "PETR4;ABEV3;ITUB3;BBDC3;BBAS3"
}, 
{
	stockExchange: "New Zealand",
	code: "NZX",
	symbols: "SPK;AIA;FBU;FPH;RYM"
}, 
{
	stockExchange: "Ireland",
	code: "ISE",
	symbols: "RY4C;TCO;CRG;APGN;GN1"
}, 
{
	stockExchange: "Singapore",
	code: "SGX",
	symbols: "S08;U14;U11;O39;F34"
}, 
{
	stockExchange: "Saudi Arabia",
	code: "TADAWUL",
	symbols: "2010;1120;1010;7010;1090"
}, 
{
	stockExchange: "Israel",
	code: "TASE",
	symbols: "TEVA;POLI;BEZQ;LUMI;ICL"
}, 
{
	stockExchange: "Indonesia",
	code: "IDX",
	symbols: "TLKM;HMSP;UNVR;BBCA;ASII"
}, 
{
	stockExchange: "Poland",
	code: "WSE",
	symbols: "PKO;PKN;PEO;PZU;KGH"
}, 
{
	stockExchange: "Mexico",
	code: "BMV",
	symbols: "AMXL;AA;CMRB;ICA;LABB"
}, 
{
	stockExchange: "Norway",
	code: "OSE",
	symbols: "DNB;STL;TEL;MHG;NHY"
}, 
{
	stockExchange: "Argentina",
	code: "BCB",
	symbols: "YPFD;ALUA;COME;MIRG;SAMI"
},
{
	stockExchange: "Thailand",
	code: "SET",
	symbols: "BBL;CPF;PTTGC;KCE;TOP"
}, 
{
	stockExchange: "Austria",
	code: "VSE",
	symbols: "TKA;RBI;SBO;ZAG;IIA"
}, 
{
	stockExchange: "Chile",
	code: "BCS",
	symbols: "SONDA;RIPLEY;FALABELLA;BSANTANDER;LAN"
}, 
{
	stockExchange: "Turkey",
	code: "BIST",
	symbols: "KCHOL;OYAYO;TRGYO;YAZIC;TOASO"
}, 
{
	stockExchange: "Estonia",
	code: "OMXT",
	symbols: "TAL1T;OEG1T;TVEAT;SFG1T;NCN1T"
},
{
	stockExchange: "Latvia",
	code: "OMXR",
	symbols: "GZE1R;LSC1R;BAL1R;OLF1R;GRD1R"
}, 
{
	stockExchange: "Lithuania",
	code: "OMXV",
	symbols: "ZMP1L;RSU1L;VLP1L;PZV1L;LNA1L"
},
{
	stockExchange: "Philippines",
	code: "PSE",
	symbols: "GLO;BPI;SMC;FGEN;MEG"
}, 
{
	stockExchange: "Abu Dhabi",
	code: "ADX",
	symbols: "ESHRAQ;ETISALAT;ALDAR;FGB;DANA"
}, 
{
	stockExchange: "Dubai",
	code: "DFM",
	symbols: "DIB;ARTC;DU;MARKA;ARMX"
}, 
{
	stockExchange: "Nigeria",
	code: "NGSE",
	symbols: "UNITYBNK;REDSTAREX;DNMEYER;MAYBAKER;UBA"
}, 
{
	stockExchange: "Colombia",
	code: "BVC",
	symbols: "ECOPETROL;GRUPOAVAL;BCOLOMBIA;GRUPOSURA;BOGOTA"
}, 
{
	stockExchange: "Qatar",
	code: "QSE",
	symbols: "QNBK;KCBK;DHBK;QNCD;QEWS"
}, 
{
	stockExchange: "Taipei",
	code: "TPE",
	symbols: "5820;5347;8299;3105;1565"
},
{
	stockExchange: "Peru",
	code: "BVL",
	symbols: "ALICORC1;BACKUBC1;GRAMONC1;SCCO;FALABEC1"
}, 
{
	stockExchange: "Egypt",
	code: "EGX",
	symbols: "ETEL;ESRS;SWDY;OCDI;OTMT"
}, 
{
	stockExchange: "Greece",
	code: "ASE",
	symbols: "AEGN;TELL;EYDAP;SAR;METKK"
}, 
{
	stockExchange: "Kenya",
	code: "NASE",
	symbols: "KQ;SCBK;ICDC;MSC;EABL"
}, 
{
	stockExchange: "Vietnam (Hanoi)",
	code: "HNX",
	symbols: "CEO;PVI;HMH;BCC;DBC"
},
{
	stockExchange: "Vietnam (Ho Chi Minh)",
	code: "HOSE",
	symbols: "BID;CII;FLC;HAG;HPG"
}, 
{
	stockExchange: "Czech Republic",
	code: "BCPP",
	symbols: "ERBAG;CEZ;KOMB;TELEC;VIG"
}, 
{
	stockExchange: "Jordan",
	code: "AMSE",
	symbols: "ARBK;BOJX;JOPT;THBK;CABK"
}
]
