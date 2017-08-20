/* eslint-disable no-undef */
var gulp = require('gulp');
var clean = require('gulp-clean');
var eslint = require('gulp-eslint');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var sourcemaps = require('gulp-sourcemaps');
var imagemin = require('gulp-imagemin');
var cleanCSS = require('gulp-clean-css');
var gutil = require('gulp-util');

gulp.task('clean', function () {
    return gulp.src('build', {read: false})
        .pipe(clean());
});

//check code specification
//more rule: http://eslint.org/docs/rules/
gulp.task('lint', function () {
    return gulp.src('portal/app/**/*.js')
        .pipe(eslint({
            'rules':{
                'no-mixed-spaces-and-tabs': 0,
                'indent':0,
                'angular/controller-as':0
            }
        }))
        .pipe(eslint.format())
        .pipe(eslint.failAfterError());
});


gulp.task('images',function(){
    return gulp.src('portal/content/img/**')
        .pipe(gulp.dest('build/img'));
});

gulp.task('css',function(){
    return gulp.src([
             'portal/content/css/layout.css',
             'portal/content/css/custom.css',
             'bower_components/angularPrint/angularPrint.css'
             ])
        .pipe(concat('main.min.css'))
        .pipe(cleanCSS()) 
        .pipe(gulp.dest('build/css'));
});

gulp.task('concat-libs', [], function() {
    return gulp.src([
          'bower_components/jquery/dist/jquery.min.js',
          'bower_components/angular/angular.js',
          'bower_components/angular-i18n/angular-locale_zh-cn.js',
          'bower_components/angular-bootstrap/ui-bootstrap.js',
          'bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
          'bower_components/angular-jwt/dist/angular-jwt.js',
          'bower_components/angular-translate/angular-translate.js',
          'bower_components/angular-translate-loader-partial/angular-translate-loader-partial.js',
          'bower_components/angular-ui-router/release/angular-ui-router.js',
          'bower_components/ngstorage/ngStorage.js',
          'bower_components/angular-loading-bar/build/loading-bar.js',
          'bower_components/angularPrint/angularPrint.js',
  		  'bower_components/message-center/message-center.js'])
        .pipe(concat('concat-libs.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('build'));
});
//minify note:please make sure use ['a',function(a)] for the directive or run, or the compress code not
//work,reference :http://blog.csdn.net/gua_381091614/article/details/50585524

gulp.task('minify-app', function () {
    return gulp.src([
      'portal/app/app.module.js',
      'portal/app/app.config.js',
      'portal/app/app.startup.js',
      'portal/app/blocks/listener/listener.module.js',
      'portal/app/blocks/listener/listener.service.js',
      'portal/app/blocks/security/security.module.js',
      'portal/app/blocks/security/security.service.js',
      'portal/app/blocks/storage/storage.module.js',
      'portal/app/blocks/storage/storage.service.js',
      'portal/app/core/core.module.js',
      'portal/app/login/login.module.js',
      'portal/app/login/login.service.js',
      'portal/app/login/login.controller.js',
      'portal/app/layout/layout.module.js',
      'portal/app/layout/layout.config.js',
      'portal/app/layout/layout.controller.js',
      'portal/app/system/system.module.js',
      'portal/app/system/system.service.js',
      'portal/app/system/user/user.module.js',
      'portal/app/system/user/user.controller.js',
      'portal/app/query/query.module.js',
      'portal/app/query/queryuser.module.js',
      'portal/app/query/query.controller.js'
         ])
        .pipe(sourcemaps.init())
        .pipe(concat('main.js'))
        .pipe(gulp.dest('build'))
        .pipe(rename({suffix: '.min'}))
        .pipe(uglify())
        .on('error', function (err) { gutil.log(gutil.colors.red('[Error]'), err.toString()); })
        .pipe(gulp.dest('build'))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('build'));
});

//please add lint when release!!!!!!!!!!!!!
gulp.task('default', ['clean'], function () {
    return gulp.start('concat-libs', 'minify-app','images','css'); 
});