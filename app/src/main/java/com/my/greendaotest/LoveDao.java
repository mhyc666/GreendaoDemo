package com.my.greendaotest;
import java.util.List;

/**
 * Created by handsome on 2016/4/19.
 */
public class LoveDao {

    /**
     * 添加数据，如果有重复则覆盖
     *
     */
    public static void insertLove(UserBean user) {
        BaseApplication.getDaoInstant().getUserBeanDao().insert(user);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        BaseApplication.getDaoInstant().getUserBeanDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(UserBean shop) {
        BaseApplication.getDaoInstant().getUserBeanDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<UserBean> queryLove() {
        return BaseApplication.getDaoInstant().getUserBeanDao().queryBuilder().where(UserBeanDao.Properties.Type.eq(UserBean.TYPE_LOVE)).list();
    }

    /**
     * 查询全部数据
     */
    public static List<UserBean> queryAll() {
        return BaseApplication.getDaoInstant().getUserBeanDao().loadAll();
    }

}
