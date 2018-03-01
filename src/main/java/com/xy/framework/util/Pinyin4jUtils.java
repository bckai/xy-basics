package com.xy.framework.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4jUtils {
	/**
	 * 将字符串中的中文转化为拼音,英文字符不变
	 *
	 * @param inputString
	 *            汉字
	 * @return
	 */
	public static String getPingYin(String inputString) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		String output = "";
		if (inputString != null && inputString.length() > 0 && !"null".equals(inputString)) {
			char[] input = inputString.trim().toCharArray();
			try {
				for (int i = 0; i < input.length; i++) {
					if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
						String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
						output += temp[0];
					} else
						output += java.lang.Character.toString(input[i]);
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		} else {
			return "*";
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(getPingYin("李  鑫"));
		System.out.println(getPingYin("王学忠"));
		System.out.println(getPingYin("宋明月"));
		System.out.println(getPingYin("李清海"));
		System.out.println(getPingYin("朱洪伟"));
		System.out.println(getPingYin("张梦晓"));
		System.out.println(getPingYin("李元兴"));
		System.out.println(getPingYin("徐汝忠"));
		System.out.println(getPingYin("訾小兵"));
		System.out.println(getPingYin("任成明"));
		System.out.println(getPingYin("李  新"));
		System.out.println(getPingYin("宋明月"));
		System.out.println(getPingYin("丁亚东"));
		System.out.println(getPingYin("周  成"));
		System.out.println(getPingYin("赵  鹏"));
		System.out.println(getPingYin("尚月华"));
		System.out.println(getPingYin("刘亚平"));
		System.out.println(getPingYin("张  超"));
		System.out.println(getPingYin("张红艳"));
		System.out.println(getPingYin("阮佳佳"));
		System.out.println(getPingYin("黄家奇"));
		System.out.println(getPingYin("赵  可"));
		System.out.println(getPingYin("黄  鑫"));
		System.out.println(getPingYin("张金东"));
		System.out.println(getPingYin("张建矿"));
		System.out.println(getPingYin("郭荐文"));
		System.out.println(getPingYin("尹大开"));
		System.out.println(getPingYin("马自良"));
		System.out.println(getPingYin("魏广场"));
		System.out.println(getPingYin("王文付"));
		System.out.println(getPingYin("戴勇彬"));
		System.out.println(getPingYin("李  岩"));
		System.out.println(getPingYin("石君华"));
		System.out.println(getPingYin("裴书文"));
		System.out.println(getPingYin("李景亮"));
		System.out.println(getPingYin("任成明"));
		System.out.println(getPingYin("申锦峰"));
		System.out.println(getPingYin("程  艳"));
		System.out.println(getPingYin("王凤云"));
		System.out.println(getPingYin("张秀丽"));
		System.out.println(getPingYin("刘  斌"));
		System.out.println(getPingYin("夏有朋"));
		System.out.println(getPingYin("韩春雨"));
		System.out.println(getPingYin("孙玉超"));
		System.out.println(getPingYin("陈鹏辉"));
		System.out.println(getPingYin("戴  超"));
		System.out.println(getPingYin("张梦晓"));
		System.out.println(getPingYin("冯海燕"));
		System.out.println(getPingYin("张  玉"));
		System.out.println(getPingYin("李文敬"));
		System.out.println(getPingYin("刘  颖"));
		System.out.println(getPingYin("高  振"));
		System.out.println(getPingYin("杨  会"));
		System.out.println(getPingYin("张春芳"));
		System.out.println(getPingYin("张靖可"));
		System.out.println(getPingYin("王  静"));
		System.out.println(getPingYin("李  刚"));
		System.out.println(getPingYin("徐  辉"));
		System.out.println(getPingYin("赵整风"));
		System.out.println(getPingYin("张民中"));
		System.out.println(getPingYin("朱沙滨"));
		System.out.println(getPingYin("程书勤"));
		System.out.println(getPingYin("张  丹"));
		System.out.println(getPingYin("段映彤"));
		System.out.println(getPingYin("訾小兵"));
		System.out.println(getPingYin("黄可可"));
		System.out.println(getPingYin("刘砚舒"));
		System.out.println(getPingYin("蒋  哲"));
		System.out.println(getPingYin("杨  光"));
		System.out.println(getPingYin("李国东"));
		System.out.println(getPingYin("卢新明"));
		System.out.println(getPingYin("会议室"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("李  新"));
		System.out.println(getPingYin("王文华"));
		System.out.println(getPingYin("赵  磊"));
		System.out.println(getPingYin("李建峰"));
		System.out.println(getPingYin("程  珩"));
		System.out.println(getPingYin("秦春雷"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("王雪燕"));
		System.out.println(getPingYin("刘小华"));
		System.out.println(getPingYin("陈  诚"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("郑耀燃"));
		System.out.println(getPingYin("办公室"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("石文标"));
		System.out.println(getPingYin("周国芮"));
		System.out.println(getPingYin("袁明娜"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("薛  军"));
		System.out.println(getPingYin("值班室"));
		System.out.println(getPingYin("王光华"));
		System.out.println(getPingYin("朱  辉"));
		System.out.println(getPingYin("谢丽君"));
		System.out.println(getPingYin("何乐平"));
		System.out.println(getPingYin("周会子"));
		System.out.println(getPingYin("李爱红"));
		System.out.println(getPingYin("陈文博"));
		System.out.println(getPingYin("朱旭峰"));
		System.out.println(getPingYin("董清真"));
		System.out.println(getPingYin("赵  凯"));
		System.out.println(getPingYin("王  峰"));
		System.out.println(getPingYin("张大勇"));
		System.out.println(getPingYin("白  伟"));
		System.out.println(getPingYin("马雅平"));
		System.out.println(getPingYin("李喜莲"));
		System.out.println(getPingYin("票据室"));
		System.out.println(getPingYin("王伟光"));
		System.out.println(getPingYin("李长虹"));
		System.out.println(getPingYin("周  伟"));
		System.out.println(getPingYin("票据室"));
		System.out.println(getPingYin("刘建峰"));
		System.out.println(getPingYin("仵希广"));
		System.out.println(getPingYin("张亚伟"));
		System.out.println(getPingYin("票据室"));
		System.out.println(getPingYin("史宝灿"));
		System.out.println(getPingYin("于  海"));
		System.out.println(getPingYin("田维霞"));
		System.out.println(getPingYin("王  楠"));
		System.out.println(getPingYin("王  静"));
		System.out.println(getPingYin("高  伟"));
		System.out.println(getPingYin("监控室"));
		System.out.println(getPingYin("票据室"));
		System.out.println(getPingYin("任  宏"));
		System.out.println(getPingYin("王总刚"));
		System.out.println(getPingYin("办公室"));

	}

}
