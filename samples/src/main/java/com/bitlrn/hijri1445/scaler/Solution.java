package com.bitlrn.hijri1445.scaler;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve("mmmmampammapmammpampampmmpmmampmppmaammmpampmmmpappmpmmppmammppmmammppppppppaamapmpmmmmppppmmpmapammmmmamppmpmmpmmmmaampaammmmamaammaampmppmaammaapaamammammapmmmmmmmmmppmmmmmmampmmmamppmmpmampmmampmmmmmmapmmaaapmpaampmmpmmmamapaammmmmmpmmmmmapapmmpmmmmmampapmaamppammmppmmaampmaaammppmmmmaammpmmaaapmmmpmammmpmapmmammapmamamapmmmmmmmppammmaapppppapppamampaammappppaappmmppaammpmmmammmaammppmmaammamammmmmmaamppappmpmpmppmppmaaapmmmppmmpmpmamamapampapmpaaamampammmpmapmammmmmaapppmammapampmmppmmpmpmmmppmmmammampmppmmammmpappappaamaampampamamamppmaaaaampmmmpmmappmmmmmmmapapammpmmmmaammaammpmmmmmppmpapmmpmmammammpmmpmmmaap");
        solution.solve("apapmaaaamppmapamaamaamaammmmppmamamapmmmaamppppmmmppmmpppmpppaaappmpaamaaapppapmmmpapppmmmmmaapppaaaapppaammmpaapampppmmmamapppamappaappppmmmpaaaappppppampppmpmmapmppaaaamapappmmmmmmamapmpmppmappapappmampappmmammmappaaapmammpmpmppappapaammmapmpppapapaaapmppmaaampaappaaaamppaaaampmpmpmmampppaamaammmmmmpamaapapmmpapaapaapmaampaapammmpmpmmapppmmpmppmmppmmappmmpmmpmpppppapaaaammappapapmmppmaamppppapaaapapaampppapppammpmammmmamapmpmpppmapammmmpmammammmampapmpammmammamapmppppmpappammpmampaamappmpmmppmmammmpaamaapmmmaaapammapmpmpammaapmammmmppmpampammppppppamammmppammapmpmppppmppmmpammpmmmpmaaapapapmpamaammmmppmmmppmpmmaaapaapmappmappaapmpmppmaampmpapaappmppaammppamppapmaaammammappapmpmpapmapapaaapaamppmpaaaapmmapamapaapppmammaampaaapppmmapmapapmappaaapapampppmpaaapapappppaaapaaaaaaaapaammappampmamampmmpmapmmaamappmmappaapppppppmaappammmaaampaaapmampapmpppmmmapppaamampmmppppmmpapaaammaapmmpppmpppamaappammmmmmmmmmamaapmapmamaaapapmmpmapaapapapmaammmpaaaapammpmaaaapmmpamampampmmmpmppaaaaapmapa");
    }

    public int solve(String A) {
        char[] input = A.toCharArray();
        int pCount = 0;
        int aCount = 0;
        int mCount = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] == 'p') {
                pCount++;
            } else if (input[i] == 'm') {
                mCount++;
            } else {
                aCount++;
            }
        }
        int result;
        if (aCount != 0 && pCount != 0) {
            result = ((aCount + pCount) == mCount) ? 1 : 0;

        } else if (aCount == 0 && pCount != 0) {
            result = (pCount == mCount) ? 1 : 0;
        } else {
            result = (aCount == mCount) ? 1 : 0;
        }
        System.out.println(result);
        return result;
    }
}