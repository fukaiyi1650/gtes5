<#macro head title>
    <head>
        <meta charset="utf-8">
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <!--[if lt IE 9]>
        <script type="text/javascript" src="${ctx}/lib/html5shiv.js"></script>
        <script type="text/javascript" src="${ctx}/lib/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui/css/H-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/H-ui.admin.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/lib/Hui-iconfont/1.0.8/iconfont.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/skin/default/skin.css" id="skin" />
        <link rel="stylesheet" type="text/css" href="${ctx}/static/h-ui.admin/css/style.css" />
        <!--[if IE 6]>
        <script type="text/javascript" src="${ctx}/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
        <script>DD_belatedPNG.fix('*');</script>
        <![endif]-->
        <title>${title}</title>
    </head>
</#macro>

<#macro breadcrumb paths>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <#list paths as path> <span class="c-gray en">&gt;</span> ${path}</#list> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
</#macro>

<#macro js>
    <!--_footer 作为公共模版分离出去-->
    <script type="text/javascript" src="${ctx}/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="${ctx}/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
    <script type="text/javascript" src="${ctx}/js/global.js" ></script>
    <#nested />
</#macro>

<#macro date id patten="%y-%M-%d">
    <input type="text" id="${id}" name="${id}" class="input-text Wdate" style="width:120px;">
</#macro>

<#macro minDate id maxId patten="%y-%M-%d">
    <input type="text" id="${id}" name="${id}" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'${maxId}\')||\'%y-%M-%d\'}' })" class="input-text Wdate" style="width:120px;">
</#macro>

<#macro maxDate id minId patten="%y-%M-%d">
    <input type="text" id="${id}" name="${id}" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'${minId}\')}',maxDate:'%y-%M-%d' })" class="input-text Wdate" style="width:120px;">
</#macro>

<#macro text id placeholder="" value="">
    <input type="text" id="${id}" name="${id}" class="input-text" style="width:250px"<#if placeholder??> placeholder="${placeholder}</#if>">
</#macro>

<#macro operate addUrl>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
            <span class="l">
                <a href="javascript:void(0);" onclick="batchDeleteByIds()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                <a href="javascript:void(0);" onclick="layer_show('添加用户','${ctx}${addUrl}','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a>
            </span>
        <span class="r">共有数据：<strong id="totalRecords">0</strong> 条</span>
    </div>
</#macro>

<#macro textfield id label value="" value="" required=true>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><#if required><span class="c-red">*</span></#if>${label}：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input type="text" class="input-text" value="${value}" placeholder="" id="${id}" name="${id}">
        </div>
    </div>
</#macro>

<#macro filefield id label required=true>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><#if required><span class="c-red">*</span></#if>${label}：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <span class="btn-upload form-group">
                <input class="input-text upload-url" type="text" id="${id}" name="${id}" readonly nullmsg="请添加附件！" style="width:200px">
                <a href="javascript:void(0);" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
                <input type="file" multiple name="file-2" class="input-file">
            </span>
        </div>
    </div>
</#macro>

<#macro selectfield id label>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3">${label}：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <span class="select-box">
				<select class="select" size="1" id="${id}" name="${id}">
                    <#nested />
				</select>
            </span>
        </div>
    </div>
</#macro>

<#macro areafield id label minlength=1 maxlength=100>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3" for="${id}">${label}：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <textarea id="${id}" name="${id}" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入${minlength}个字符" onKeyUp="$.Huitextarealength(this,${maxlength})"></textarea>
            <p class="textarea-numberbar"><em class="textarea-length">0</em>/${maxlength}</p>
        </div>
    </div>
</#macro>

<#macro submit>
    <div class="row cl">
        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
            <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
        </div>
    </div>
</#macro>

<#macro radiofield name label items required=true>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><#if required><span class="c-red">*</span></#if>${label}：</label>
        <div class="formControls col-xs-8 col-sm-9 skin-minimal">
            <#list items as item>
                <div class="radio-box">
                    <input name="sex" type="radio" id="${name}-${item_index}" value="${item[1]}" <#if item_index==0>checked</#if>>
                    <label for="${name}-${item_index}">${item[0]}</label>
                </div>
            </#list>
        </div>
    </div>
</#macro>

