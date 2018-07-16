var hColor = void 0,
    header = $("#card header");
function getDayLight() {
    var e = new Date,
        t = e.getHours() - 12,
        n = t ? Math.abs(t) / t : 1,
        a = ((t += (60 * e.getMinutes() + e.getSeconds()) / 3600) / 4 - n) * n;
    return a = Math.max(a, 0), a = Math.min(0.8, a)
}
function setLightColor() {
    $("#page").css("background-color", "rgba(85,85,85," + getDayLight() + ")"),
        (new Date).getHours() < 17 && (title.style = "color:#666")
}
function preLoad() {
    var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : "iframe",
        t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "//tomotoes.com/blog",
        n = document.createElement(e);
    return n.style.display = "none", n.src = t, document.body.appendChild(n), preLoad
}
var title = document.getElementById("typetitle"),
    typingbefore = "欢迎来到冉萌！",
    _i = 0,
    countCall = 0,
    countC = 0,
    callCount = 0;
function typetitle() {
    _i <= typingbefore.length ? (title.innerHTML = typingbefore.slice(0, _i++) + "|", setTimeout(typetitle, 100)) : title.innerHTML = typingbefore
}
function messenger(e) {
    var t = this;
    t.init = function () {
        t.codeletters = "&#*+%?￡@§$",
            t.message = 0,
            t.current_length = 0,
            t.fadeBuffer = !1,
            t.messages = ["..."],
            setTimeout(t.animateIn, 100)
    },
        t.generateRandomString = function (e) {
            for (var n = ""; n.length < e;)
                n += t.codeletters.charAt(Math.floor(Math.random() * t.codeletters.length));
            return n
        },
        t.animateIn = function () {
            if (t.current_length < t.messages[t.message].length)
                t.current_length = t.current_length + 2,
                    t.current_length > t.messages[t.message].length && (t.current_length = t.messages[t.message].length),
                    $(e).html(t.generateRandomString(t.current_length)),
                    setTimeout(t.animateIn, 20);
            else {
                if (++callCount > 2)
                    return;
                setTimeout(t.animateFadeBuffer, 20)
            }
        },
        t.animateFadeBuffer = function () {
            if (!1 === t.fadeBuffer) {
                t.fadeBuffer = [];
                for (var n = 0; n < t.messages[t.message].length; n++)
                    t.fadeBuffer.push({
                        c: Math.floor(12 * Math.random()) + 1,
                        l: t.messages[t.message].charAt(n)
                    })
            }
            for (var a = !1, o = "", r = 0; r < t.fadeBuffer.length; r++) {
                var i = t.fadeBuffer[r];
                i.c > 0 ? (a = !0, i.c-- , o += t.codeletters.charAt(Math.floor(Math.random() * t.codeletters.length))) : o += i.l
            }
            if ($(e).html(o), !0 === a) {
                if (15 == ++countC)
                    return preLoad.call()("img", "//tomotoes.com/images/live2d/" + Number(localStorage.getItem("model")) + ".png"), typetitle(), void (countCall = 3); if (!(countC < 15)) return; setTimeout(t.animateFadeBuffer, 50)
            } else {
                if (countCall > 2)
                    return;
                2 == ++countCall ? (preLoad.call()("img", "//tomotoes.com/images/live2d/" + Number(localStorage.getItem("model")) + ".png"), typetitle()) : t.cycleText()
            }
        },
        t.cycleText = function () {
            t.message = t.message + 1,
                t.message >= t.messages.length && (t.message = 0),
                t.current_length = 0,
                t.fadeBuffer = !1,
                $(e).html(""),
                setTimeout(t.animateIn, 200)
        },
        t.init()
}
var ofade = document.querySelector(".card-wrap");
function enter() {
    setLightColor(), setTimeout(function () {
        new Promise(function (e, t) {
            e(ofade.classList.add("in"))
        }).then(function () {
            document.querySelector(".coding").classList.add("jump"),
                new messenger($("#typetitle"))
        })
    }, 400
    )
}
window.addEventListener("beforeunload", function () {
    ofade.classList.remove("in")
}),
    document.body.onmousewheel = function () {
        window.loaded || (navigate(), enter())
    },
    document.querySelector(".arrow").addEventListener("mouseenter", function () {
        navigate(), enter()
    });
var isPhone = /Mobile|Android|iOS|iPhone|iPad|iPod|Windows Phone|KFAPWI/i.test(navigator.userAgent) && window.innerWidth < 760;
if (isPhone) {
    var getAngle = function (e, t) {
        return 180 * Math.atan2(t, e) / Math.PI
    },
        getDirection = function (e, t, n, a) {
            var o = n - e, r = a - t, i = 0;
            if (Math.abs(o) < 2 && Math.abs(r) < 2)
                return i;
            var s = getAngle(o, r);
            return s >= -135 && s <= -45 ? i = 1 : s > 45 && s < 135 ? i = 2 : s >= 135 && s <= 180 || s >= -180 && s < -135 ? i = 3 : s >= -45 && s <= 45 && (i = 4), i
        },
        startx = void 0,
        starty = void 0;
    document.addEventListener("touchstart", function (e) {
        startx = e.touches[0].pageX,
            starty = e.touches[0].pageY
    }, !1),
        document.addEventListener("touchend", function (e) {
            var t, n;
            t = e.changedTouches[0].pageX,
                n = e.changedTouches[0].pageY,
                1 !== getDirection(startx, starty, t, n) || window.loaded || (navigate(), enter())
        }, !1)
}