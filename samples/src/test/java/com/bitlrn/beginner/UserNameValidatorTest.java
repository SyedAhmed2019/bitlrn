package com.bitlrn.beginner;

import com.bitlrn.hacker.UserNameValidator;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.Scanner;

public class UserNameValidatorTest {
    @Test
    public void testLargeInputUsername() throws InterruptedException {

        String input[] = {"jp83+ZVX_oYE_T$mlH-QqYIvYhKD#",
                "pNP5riufbZGd@zyl$aBAc@sl_z5a4Kob7k#qSX@ydHA4B1a7X6D",
                "TIrjdU2fYSNCWLJSU3F6gsXJIcIINV0CuuH#awSOnqQ32Udt1HywVDn55CgiD_K#",
                "H#Yyzgw=0TdEo31MW6174Xzu9QU", "nDeFGdtz1rOFdze8zBbf3nKoY3i7r5tV$",
                "l43_XRaku=Lk9MU+cyyujcDgP7EMxhSHaDFc5T6a7lWp87ktJiek=m",
                "FtcbBUe9tpuDF+TxUnCjRvC8l6DUvNTZ8yFoLPRKKlkoJ9_fc=ifvyybsJ2aGhw9cQIHu-8V5z7wxe#1j=P$Gr9tr++K",
                "NqYoagF1M#@mU=xGMhhzu",
                "rP#RWJpf##99Glc1zrp5CE0VXAu83t10$pg1-j-gO-Z=ZmG=#$+jLfV@qob8xkAlPPHTaTSa1mmtDCBm4c0v",
                "JUBlzA@EmwLkTLAlTOdeXl#7O3mg_E3qQRY$p",
                "QkMI8@E$Z_RRv2uDKmC2TwMgCt2kp1-jumqBmvS2lSSP4I-ObzOYc=NaimLMLJR_9RxgZ7CeK--oPQ-HaO6-Jv+N",
                "rF2_=g=lpUcr_cUXwV6k3FzPPxX2hKjPn2$nKicjOWdLOghhYoW$KGG49K-Rdl=vD3Ql##cd8vwCjKBJ3zjNdLX5iLW6n42",
                "I-C+1@XF#l3hHAN18lYss0J=lNLC2_uSphRbJnNiLRrmi71X=4DdNR273EYxQCkq",
                "tZFUL8HYEsqoG2@eo_qhksTj=CmuIwzYl8c2Pfdt#ujAesyDZr_2gn1wOZ1GMl2oaLP4$3xId7_JO2BT6Npr=qDJ",
                "odTRbgut7MPxFlYGYNXmE1ao#M_ZY_",
                "my#XEgdr1rDq71lhgT",
                "6fEAERaWr6LFd=$k$diTkV3XrJzTopt08DjimsatXt4W$flWl#AzgSEanqXGEdAWn2fWR#U-ArJzv@QD4_SN47H8wu7t5@egvDw",
                "1q1Zn$eDk", "bIP#=vRB9Z4UHBYe##aK+Ft4h_a@Q_E9IMTXW39b", "1Dnw3kDdQ-MGhhIPm5+378=$+HUm$$dyxjElNa2E7VQegeewRvYIjypbaCXTsVPfti91mIKUWN@AOOxakQfXeQMHtS", "3Se9R_e4#w8PAbIjd64L2SmwkiG1cZ@OjTZDt8@h=iQ", "@7O0xw_MTCP-fOvk8XQQLKwMx1TVscPTtLpHL=dv2Lyq8jgX#borKhr=PVbUd#FqDw", "Mu=KJl-VYx5piDEqUWWoue@gRfiNw92m8@", "Y#fm3a#OTM#3ukWhf8DItcDASIfcq$a#tPSdSR0Ovqxz3Dl4LQ+TXarF8IT0G", "50F6IfGH#bj31xt_-mY0ZPfww7ENJM_BUkcD39zofDOy=mcUp5#Xho7_Waxj=", "F5DhJ-SkaXLyfWAD", "T9N=iSnlN$4eOA-iq4IUK$", "3GsURoLA-11gTg6ePDT2#QJ0VtgbYA$+LWtl2CGE4$", "Ea=9ATZqsoJnEEqt-s5cqC=7x3#YShabi-nPcE@Qs46thFkJq5WP@EwFUH_LYyA0iKS", "Z4mWA_7RS", "GcZyk$#5UIvfOTKHEWB23wJ#L$=hov-1Df0QMluFnNAPagFi7", "ylFTy#bXbtIk98+DPyUvOZKVygqv=HX2LJOzLi4xHzAD", "nRNkJl3umQoGgH4KDVe8NReUHk2QABpqINqejYoA$nC9T7KhC3UJyeF1_m7TRPXAvevI3C4rY56A-poEQK", "AqU=Ok@eRb1Wu#mHrv5Di_$WROB=LClh", "lzpyGF_n4g", "v+1UI$FnIY04#7pILX@kQaqJhaTmH6bKGNxoq2v0r3VHGI#SZ3iG", "hxRo32ldf3UxTC$qCdzNW7kKzljxxmvJOXFMOO=v", "$d#+mp0gmktZ_KqD$48TXkptKH_fbAYWufx5_I3uTDQVhr-wzG-4gprL5+YAqggVW6quPqV9Wi8FFwWETJso#Tpz", "r$Ti63eILcNL3s5Hw0H35_S=4EncNP@aCioZOTFL-kDEd@h#HdosNsCwhi", "$UqiY2T8HBMB2@yFo4TXs7Y4x6oraz9ajpG=ZBUUZ7uVEGVS2z6i$oges2WB2TLEmdVnG6x#M9uKGAU", "-UfqrlX4RktTbOZWE#MaPSq#kcjo7Sbt181d2P", "Iky4CEa3mPK3YXBKi5u3R#M", "ZY5bHxI05t6xQpS-3qiC54nSpd9xw9c=edJ3X0=4CL", "OeXV3f8=x8Le=xR", "OYgh#WM4VUCSWJ", "4Z#mKWARgZ0esKgsWYlBXN+85W+rnnS6sqKRjlUXeIy$I_lAOVBbS4VHyj12oBWe_d#DxI1B2K47grNq-9BneJBcv_2gNx9", "vyqzw3nxPMcd+w#9=-Fa@ghs838ZsNvLLDfgrreGAjW", "uRZxRQsrEtT3vx+8i#Z", "mKIHg#sCLquCdnsf4f_cHQcfBwi#p8Jo5h", "od=QFPWt#gt4f1VuCwlP#hMh@VJqn_1G6L5bAGY9CMS6ROiZs2C2hcZx=ihhlyGJqqB@zE4e44U_OH8YSrzCrf@uFTw", "cpzk1ZUwEKZnIFnb1BS+_iDi1sKhl@w8z8", "-L_Lc3QkyG@JYh9@seHoLIa1Ad@G07G2Sf", "bvB$iVCtnNt5WcQZu+7#SuJkWWhN-1IQfrQ8W#XJ63Qs9c$WXZ+vij5kn3QCUeGlftVLqTSh1qEdiSsLJ4", "FEO@Dy_9bVIm45DN4u-t4qYQXcTXsNgG=#R1OlCX5i", "YUz2XFCowmxSkAcpjc64d_L-Wm$ZYW--jnAM-oUphFlECHra16xdTjYDnvW7tzpKw0npjtJnuPa0oRqx5#MaBnaCf=3", "XIx_1UehOeDOk2xjeUDiES9N3=GDgI0cD0nm$ZkGDdntJBMoYAQSt8O6KFrKtgVjE4M1kg2Biy9DLVDX52=s=QDK47rEEXlGS", "NZn305y6wBF=c+JQpgGM6==enTDN", "Gc=$x==P4TGUcIyCo1gjeA$FF8JlXbL", "Jat4J$Fa0Zz4LK7FP9Kk3sPPbr1bjdF0YHYhiSr@HWScPDIskNE9crIVHHkhRLOgSSed8SF-YWcoMG0l", "Rk$rnvmoTFEb1N9UmGorGb5hu1h23O#3FabDFwkH#jKk@e@G8T7PUOUFpVWi=-ncD-4q@lV7w9SMjQxPo3vVnBfumNAUe", "5m$GflsX$n_y#TEb3+nS#U2aFdGJSN1zXZ=DHOq#7-Yq8v=cQ2y$MU+2EonWD@xT2nVXQuGUMYuwYT0t53vb", "+sT7EXm6bE#NnygG=s+8ZScbyTztd=ia6bfGx0MS1FX8f8fedFoDGmo", "b34uQfH@iDaRqCBOTk-0QlAattGzgoAQ3hP3qFYsuTVNEkM6i5FhuTbzY=YeFQMO8rFyLP#rw6=E7z", "y0ZBTyHYQUkrlu7NU3#u_zmbpAK4s-v5Wz=DqJDL", "=K5ypZ74xA", "u1oqNclihj+MzsvJbXBAUn=$cpopi36vS-XuMra#Pi1$7ndvy$a", "-c7rOSrSIUfstv$aQS-tlwr@qn-7BE9sOYE9#thYry9JHAS1", "j#QzHpq-aNETaIw@$NeB8ejseHVwrF", "4ZwP6yHKJt+rxwtUM36fwaOgK$2-7vG7jK0Gy-E5Kl6jY8", "+r=N6F+A6As9bJf6E+jJAuYDI", "K-hdbR_", "mgIVV1Njm-o50uFbBQOV5oobg+bGKGDrz72rVLHg2PK8e1uwI6LvbtTGR8", "cp4kqWptNeY$xsZx4v54cUl0K7FNkR-0GrgzIbzJVJNwCsZx", "PX9l3HwqDFj-islzz2S#9jS99oQd0apIMR@r#pU7WC6@F5uu$_B#v=gfv5=W", "BTzFw6v#@3xHNJMPyETIDuJSEtlL$97@@", "zFb=ftqM7iYozIoMj5139OdLqQ=4+eYLyjKIFm", "z3RwXN9b", "h7ZJjqQP32phCMPTpqjRK#y_cepGd#qMfWw=lHMHZn0RARUAUja", "BLeVUcevqj+Eqxp45mdxZSSU-siymvPmB--PTcRy9gr6Jybq3", "tD2_tiff+Z66fC", "oi3_w0f5J@i3p=bT6wE75P_OV0tpIG=4ef6tv#e@vV+TJ57vhEwpuYdn9YqMKlZMhCD0JZAUwTPTpyOkkPKgBs0uFrnYqmyFk0", "7FgFqw1@JNnMvn5X3dTo=BA#TsIqbO-3cKv_gIMwCkbda3ed_RulnjWUhP1R=uL_", "LBhozrwteaMLj", "xwAQ=Y7wcdO-uyyp4-p6YyM0zVSMJPuDSYu7R1OTMM5u", "ix##2XRfuyIt_6DZwqi=_HlgN@O48HX", "$k8WDX8MkUJPF+1TS4eywg_i-HrpcDxyYRUYZo-kldOAdRzO6osvOX339vdntTh#3aTQb3kUI_Ky$TRK#KXzPeyq", "uQc6IKYYeDIpHSMO7swQHe_4Umu+Sblfi-wyCLVffJuTztD3S", "VQqifKiRYfFOXKaeubdxchoI=aHoazNgxgSFFHjj-aoGOzSSC+3KQpjFWtIvjMLq2fh0y8uy", "d1aAaKSL1CvIR9Ycuzith$nRDy1HuiOFCSFYNY@3kv9X_R$ziCPxH=M63=9+ZWW-GmcY8k0xNwSHBgj17gFbc8pjWRgfl_f", "yJjiUfPG-TJi", "kCl3ptT#hWrj9PkLVsTTpB", "gYn@PT2CazGKtcuOwBtuCj9YHYOu+U_WAvIT+d", "9boIgKI@aHnPgmWdqRyY7q", "qVUnW=x_hODFNk0B6uB8mIGLHbEM95@NZOPUqflMjvyMabGw@XYt739HdK@mNr3f7xWHL0H+97sZyJK+qBOpQ@5hKTaGACFj+c", "_4gQhkQ$aXULNxERH=qY6IJY6V$2OW+ae0", "jGSSsWkC22tggXgXFwC+@n4IX#HGsJ6+gMEGRSdzlcl$R$ZGs$N=WyeLPujKtJyKj@Z1WpjoK6_iWAKeNq+", "$rRr-gvgD5dMAnsES4RLCcXxZaHaGtufsjwE0g1ilWkg6V37rkjZlphDP1vvcDd92l", "Lpm#$Rv7zt", "tBA2kOMM7RK819fFSZTDiUarmH$mxTO41bIcakUzHLR1npZjW#mMfUqbMSH90+HD1BUcvGTqR8h@C9wg", "XBtUc4aomDgqZSQyK48#Tj=b9"


        };

        UserNameValidator.checkManyUserNames(input);

    }
}
