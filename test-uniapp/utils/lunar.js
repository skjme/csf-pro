var b = {
    lunarInfo: [ 19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560 ],
    solarMonth: [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ],
    Gan: [ "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" ],
    Zhi: [ "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" ],
    Animals: [ "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" ],
    solarTerm: [ "小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至" ],
    sTermInfo: [ "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c3598082c95f8c965cc920f", "97bd0b06bdb0722c965ce1cfcc920f", "b027097bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c359801ec95f8c965cc920f", "97bd0b06bdb0722c965ce1cfcc920f", "b027097bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c359801ec95f8c965cc920f", "97bd0b06bdb0722c965ce1cfcc920f", "b027097bd097c36b0b6fc9274c91aa", "9778397bd19801ec9210c965cc920e", "97b6b97bd19801ec95f8c965cc920f", "97bd09801d98082c95f8e1cfcc920f", "97bd097bd097c36b0b6fc9210c8dc2", "9778397bd197c36c9210c9274c91aa", "97b6b97bd19801ec95f8c965cc920e", "97bd09801d98082c95f8e1cfcc920f", "97bd097bd097c36b0b6fc9210c8dc2", "9778397bd097c36c9210c9274c91aa", "97b6b97bd19801ec95f8c965cc920e", "97bcf97c3598082c95f8e1cfcc920f", "97bd097bd097c36b0b6fc9210c8dc2", "9778397bd097c36c9210c9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c3598082c95f8c965cc920f", "97bd097bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c3598082c95f8c965cc920f", "97bd097bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c359801ec95f8c965cc920f", "97bd097bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c359801ec95f8c965cc920f", "97bd097bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf97c359801ec95f8c965cc920f", "97bd097bd07f595b0b6fc920fb0722", "9778397bd097c36b0b6fc9210c8dc2", "9778397bd19801ec9210c9274c920e", "97b6b97bd19801ec95f8c965cc920f", "97bd07f5307f595b0b0bc920fb0722", "7f0e397bd097c36b0b6fc9210c8dc2", "9778397bd097c36c9210c9274c920e", "97b6b97bd19801ec95f8c965cc920f", "97bd07f5307f595b0b0bc920fb0722", "7f0e397bd097c36b0b6fc9210c8dc2", "9778397bd097c36c9210c9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bd07f1487f595b0b0bc920fb0722", "7f0e397bd097c36b0b6fc9210c8dc2", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf7f1487f595b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf7f1487f595b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf7f1487f531b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c965cc920e", "97bcf7f1487f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b97bd19801ec9210c9274c920e", "97bcf7f0e47f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "9778397bd097c36b0b6fc9210c91aa", "97b6b97bd197c36c9210c9274c920e", "97bcf7f0e47f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "9778397bd097c36b0b6fc9210c8dc2", "9778397bd097c36c9210c9274c920e", "97b6b7f0e47f531b0723b0b6fb0722", "7f0e37f5307f595b0b0bc920fb0722", "7f0e397bd097c36b0b6fc9210c8dc2", "9778397bd097c36b0b70c9274c91aa", "97b6b7f0e47f531b0723b0b6fb0721", "7f0e37f1487f595b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc9210c8dc2", "9778397bd097c36b0b6fc9274c91aa", "97b6b7f0e47f531b0723b0b6fb0721", "7f0e27f1487f595b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "9778397bd097c36b0b6fc9274c91aa", "97b6b7f0e47f531b0723b0787b0721", "7f0e27f0e47f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "9778397bd097c36b0b6fc9210c91aa", "97b6b7f0e47f149b0723b0787b0721", "7f0e27f0e47f531b0723b0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "9778397bd097c36b0b6fc9210c8dc2", "977837f0e37f149b0723b0787b0721", "7f07e7f0e47f531b0723b0b6fb0722", "7f0e37f5307f595b0b0bc920fb0722", "7f0e397bd097c35b0b6fc9210c8dc2", "977837f0e37f14998082b0787b0721", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e37f1487f595b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc9210c8dc2", "977837f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "977837f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd097c35b0b6fc920fb0722", "977837f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "977837f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "977837f0e37f14998082b0787b06bd", "7f07e7f0e47f149b0723b0787b0721", "7f0e27f0e47f531b0b0bb0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "977837f0e37f14998082b0723b06bd", "7f07e7f0e37f149b0723b0787b0721", "7f0e27f0e47f531b0723b0b6fb0722", "7f0e397bd07f595b0b0bc920fb0722", "977837f0e37f14898082b0723b02d5", "7ec967f0e37f14998082b0787b0721", "7f07e7f0e47f531b0723b0b6fb0722", "7f0e37f1487f595b0b0bb0b6fb0722", "7f0e37f0e37f14898082b0723b02d5", "7ec967f0e37f14998082b0787b0721", "7f07e7f0e47f531b0723b0b6fb0722", "7f0e37f1487f531b0b0bb0b6fb0722", "7f0e37f0e37f14898082b0723b02d5", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e37f1487f531b0b0bb0b6fb0722", "7f0e37f0e37f14898082b072297c35", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e37f0e37f14898082b072297c35", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e37f0e366aa89801eb072297c35", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f149b0723b0787b0721", "7f0e27f1487f531b0b0bb0b6fb0722", "7f0e37f0e366aa89801eb072297c35", "7ec967f0e37f14998082b0723b06bd", "7f07e7f0e47f149b0723b0787b0721", "7f0e27f0e47f531b0723b0b6fb0722", "7f0e37f0e366aa89801eb072297c35", "7ec967f0e37f14998082b0723b06bd", "7f07e7f0e37f14998083b0787b0721", "7f0e27f0e47f531b0723b0b6fb0722", "7f0e37f0e366aa89801eb072297c35", "7ec967f0e37f14898082b0723b02d5", "7f07e7f0e37f14998082b0787b0721", "7f07e7f0e47f531b0723b0b6fb0722", "7f0e36665b66aa89801e9808297c35", "665f67f0e37f14898082b0723b02d5", "7ec967f0e37f14998082b0787b0721", "7f07e7f0e47f531b0723b0b6fb0722", "7f0e36665b66a449801e9808297c35", "665f67f0e37f14898082b0723b02d5", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e36665b66a449801e9808297c35", "665f67f0e37f14898082b072297c35", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e26665b66a449801e9808297c35", "665f67f0e37f1489801eb072297c35", "7ec967f0e37f14998082b0787b06bd", "7f07e7f0e47f531b0723b0b6fb0721", "7f0e27f1487f531b0b0bb0b6fb0722" ],
    nStr1: [ "日", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" ],
    nStr2: [ "初", "十", "廿", "卅" ],
    nStr3: [ "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊" ],
    lYearDays: function(f) {
        var c, e = 348;
        for (c = 32768; c > 8; c >>= 1) e += b.lunarInfo[f - 1900] & c ? 1 : 0;
        return e + b.leapDays(f);
    },
    leapMonth: function(f) {
        return 15 & b.lunarInfo[f - 1900];
    },
    leapDays: function(f) {
        return b.leapMonth(f) ? 65536 & b.lunarInfo[f - 1900] ? 30 : 29 : 0;
    },
    monthDays: function(f, c) {
        return c > 12 || c < 1 ? -1 : b.lunarInfo[f - 1900] & 65536 >> c ? 30 : 29;
    },
    solarDays: function(f, c) {
        if (c > 12 || c < 1) return -1;
        var e = c - 1;
        return 1 == e ? f % 4 == 0 && f % 100 != 0 || f % 400 == 0 ? 29 : 28 : b.solarMonth[e];
    },
    toGanZhiYear: function(f) {
        var c = (f - 3) % 10, e = (f - 3) % 12;
        return 0 == c && (c = 10), 0 == e && (e = 12), b.Gan[c - 1] + b.Zhi[e - 1];
    },
    toAstro: function(b, f) {
        var c = [ 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 ];
        return "魔羯水瓶双鱼白羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯".substr(2 * b - (f < c[b - 1] ? 2 : 0), 2) + "座";
    },
    toGanZhi: function(f) {
        return b.Gan[f % 10] + b.Zhi[f % 12];
    },
    getTerm: function(f, c) {
        if (f < 1900 || f > 2100) return -1;
        if (c < 1 || c > 24) return -1;
        var e = b.sTermInfo[f - 1900], a = [ parseInt("0x" + e.substr(0, 5)).toString(), parseInt("0x" + e.substr(5, 5)).toString(), parseInt("0x" + e.substr(10, 5)).toString(), parseInt("0x" + e.substr(15, 5)).toString(), parseInt("0x" + e.substr(20, 5)).toString(), parseInt("0x" + e.substr(25, 5)).toString() ], r = [ a[0].substr(0, 1), a[0].substr(1, 2), a[0].substr(3, 1), a[0].substr(4, 2), a[1].substr(0, 1), a[1].substr(1, 2), a[1].substr(3, 1), a[1].substr(4, 2), a[2].substr(0, 1), a[2].substr(1, 2), a[2].substr(3, 1), a[2].substr(4, 2), a[3].substr(0, 1), a[3].substr(1, 2), a[3].substr(3, 1), a[3].substr(4, 2), a[4].substr(0, 1), a[4].substr(1, 2), a[4].substr(3, 1), a[4].substr(4, 2), a[5].substr(0, 1), a[5].substr(1, 2), a[5].substr(3, 1), a[5].substr(4, 2) ];
        return parseInt(r[c - 1]);
    },
    toChinaMonth: function(f) {
        if (f > 12 || f < 1) return -1;
        var c = b.nStr3[f - 1];
        return c += "月";
    },
    toChinaDay: function(f) {
        var c;
        switch (f) {
          case 10:
            c = "初十";
            break;

          case 20:
            c = "二十";
            break;

          case 30:
            c = "三十";
            break;

          default:
            c = b.nStr2[Math.floor(f / 10)], c += b.nStr1[f % 10];
        }
        return c;
    },
    getAnimal: function(f) {
        return b.Animals[(f - 4) % 12];
    },
    solar2lunar: function(f, c, e) {
        if (f < 1900 || f > 2100) return -1;
        if (1900 == f && 1 == c && e < 31) return -1;
        if (f) a = new Date(f, parseInt(c) - 1, e); else var a = new Date();
        var r, t = 0, d = 0, f = a.getFullYear(), c = a.getMonth() + 1, e = a.getDate(), n = (Date.UTC(a.getFullYear(), a.getMonth(), a.getDate()) - Date.UTC(1900, 0, 31)) / 864e5;
        for (r = 1900; r < 2101 && n > 0; r++) n -= d = b.lYearDays(r);
        n < 0 && (n += d, r--);
        var s = new Date(), u = !1;
        s.getFullYear() == f && s.getMonth() + 1 == c && s.getDate() == e && (u = !0);
        var o = a.getDay(), l = b.nStr1[o];
        0 == o && (o = 7);
        var i = r, t = b.leapMonth(r), h = !1;
        for (r = 1; r < 13 && n > 0; r++) t > 0 && r == t + 1 && 0 == h ? (--r, h = !0, 
        d = b.leapDays(i)) : d = b.monthDays(i, r), 1 == h && r == t + 1 && (h = !1), n -= d;
        0 == n && t > 0 && r == t + 1 && (h ? h = !1 : (h = !0, --r)), n < 0 && (n += d, 
        --r);
        var D = r, g = n + 1, y = c - 1, p = b.toGanZhiYear(i), v = b.getTerm(i, 2 * c - 1), m = b.getTerm(i, 2 * c), M = b.toGanZhi(12 * (f - 1900) + c + 11);
        e >= v && (M = b.toGanZhi(12 * (f - 1900) + c + 12));
        var T = !1, I = null;
        v == e && (T = !0, I = b.solarTerm[2 * c - 2]), m == e && (T = !0, I = b.solarTerm[2 * c - 1]);
        var C = Date.UTC(f, y, 1, 0, 0, 0, 0) / 864e5 + 25567 + 10, S = b.toGanZhi(C + e - 1), Y = b.toAstro(c, e);
        return {
            lYear: i,
            lMonth: D,
            lDay: g,
            Animal: b.getAnimal(i),
            IMonthCn: (h ? "闰" : "") + b.toChinaMonth(D),
            IDayCn: b.toChinaDay(g),
            cYear: f,
            cMonth: c,
            cDay: e,
            gzYear: p,
            gzMonth: M,
            gzDay: S,
            isToday: u,
            isLeap: h,
            nWeek: o,
            ncWeek: "星期" + l,
            isTerm: T,
            Term: I,
            astro: Y
        };
    },
    lunar2solar: function(f, c, e, a) {
        var a = !!a, r = b.leapMonth(f);
        b.leapDays(f);
        if (a && r != c) return -1;
        if (2100 == f && 12 == c && e > 1 || 1900 == f && 1 == c && e < 31) return -1;
        var t = b.monthDays(f, c), d = t;
        if (a && (d = b.leapDays(f, c)), f < 1900 || f > 2100 || e > d) return -1;
        for (var n = 0, s = 1900; s < f; s++) n += b.lYearDays(s);
        for (var u = 0, o = !1, s = 1; s < c; s++) u = b.leapMonth(f), o || u <= s && u > 0 && (n += b.leapDays(f), 
        o = !0), n += b.monthDays(f, s);
        a && (n += t);
        var l = Date.UTC(1900, 1, 30, 0, 0, 0), i = new Date(864e5 * (n + e - 31) + l), h = i.getUTCFullYear(), D = i.getUTCMonth() + 1, g = i.getUTCDate();
        return b.solar2lunar(h, D, g);
    }
};

module.exports = {
    Calendar: b
};