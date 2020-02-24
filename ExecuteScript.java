import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExecuteScript {
    static HashMap<String, List<String>> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> list = Arrays.asList("NFT_DCPinChangeRequestEvent", "FT_WmsEvent",
                "NFT_BillerEvent", "FT_FundtransferEvent", "FT_GenericenEvent", "NFT_BeneficiaryEvent",
                "NFT_AccountInquiryEvent", "NFT_ScnclosureEvent", "NFT_IbLoginEvent", "NFT_ChequeBookRequestEvent",
                "NFT_EipoapplicantEvent", "FT_BillpaymentEvent", "FT_EpiEvent", "NFT_DclimitchangeEvent",
                "NFT_NPCIChequeDetailsEvent", "FT_CoreAcctTxnEvent", "FT_EipoapplicationEvent", "NFT_ChequeReturnEvent",
                "NFT_CredentialChangeEvent", "NFT_DebitCardRequestEvent", "NFT_AccountStatusChangeEvent",
                "FT_WMTxnEvent", "NFT_StaticinfochangeEvent");
        list.forEach(eventName -> {
            Process p = null;
            try {
                p = Runtime.getRuntime().exec("grep -irl \"" + eventName + "\"", null,
                        new File("/home/yashaswi/cxps/dev/Clari5-EFM-4.8-yes-baseline/workspace/bin/releases/48.D11P1b/data/dev-src/KEN/scenarios"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            br.lines().filter(line -> line.endsWith("_scenario.xml"))
                    .forEach(line -> {
                        if (line.startsWith("Noncustomer")) {
                            line = line.substring(29);
                            if (!hm.containsKey(eventName)) {
                                List<String> scnList = new ArrayList<>();
                                scnList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnList);
                            } else {
                                List<String> scnUpdateList = hm.get(eventName);
                                scnUpdateList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnUpdateList);
                            }
                            //System.out.println(line.substring(0, line.lastIndexOf("_")));
                        } else if (line.startsWith("Customer")) {
                            line = line.substring(26);
                            if (!hm.containsKey(eventName)) {
                                List<String> scnList = new ArrayList<>();
                                scnList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnList);
                            } else {
                                List<String> scnUpdateList = hm.get(eventName);
                                scnUpdateList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnUpdateList);
                            }
                            //System.out.println(line.substring(0, line.lastIndexOf("_")));
                        } else if (line.startsWith("Account")) {
                            line = line.substring(25);
                            if (!hm.containsKey(eventName)) {
                                List<String> scnList = new ArrayList<>();
                                scnList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnList);
                            } else {
                                List<String> scnUpdateList = hm.get(eventName);
                                scnUpdateList.add(line.substring(0, line.lastIndexOf("_")));
                                hm.put(eventName, scnUpdateList);
                            }
                            //System.out.println(line.substring(0, line.lastIndexOf("_")));
                        }
                    });
        });
        //System.out.println(hm);

        List<String> ls = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            String val = entry.getValue().toString()
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll(", ", "\\|");
            String str = "";
            str += "INSERT INTO EVENT_TO_FACTNAME_MAPPING ('EVENT_NAME','FACT_NAME') VALUES('" + entry.getKey() + "','" + val + "');";
            ls.add(str);
        }
        //System.out.println(ls);
        for (String s : ls) {
            System.out.println(s);
        }
    }
}