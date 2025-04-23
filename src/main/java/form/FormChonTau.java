package form;

import component.ChoNgoiItem;
import component.DataSearch;
import component.FormListDontreo;
import component.FormToaGhe;
import component.FormToaNam;
import component.IconToa;
import component.PanelSearch;
import component.TauItem;
import component.jFrameMuaVe;
import dao.ChiTietVeDao;
import dao.ChoNgoiDao;
import dao.ChuyenDao;
import dao.GaDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.KhuyenMaiDao;
import dao.ToaDao;
import dao.TuyenDao;
import dao.VeDao;
import entity.ChiTietVe;
import entity.ChoNgoi;
import entity.Chuyen;
import entity.Ga;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.TaiKhoan;
import entity.Toa;
import entity.Ve;
import event.EvenItemGaClick;
import event.EvenItemTau;
import event.EventItemToa;
import jakarta.persistence.EntityManagerFactory;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import model.Model_InfoVe;
import model.Model_Tau;
import swing.ScrollBar;
import swing.ScrollBar2;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

public class FormChonTau extends JPanel {

	public EvenItemTau getEvent() {
		return eventTau;
	}

	public void setEvent(EvenItemTau event) {
		this.eventTau = event;
	}

	public void setEventToa(EventItemToa eventToa) {
		this.eventToa = eventToa;
	}

	public EventItemToa getEventToa() {
		return eventToa;
	}

	private Ga gaDau;
	private Ga gaCuoi;
	private EntityManagerFactory emf;
	private EventItemToa eventToa;
	private EvenItemTau eventTau;
	private MainForm main;
	private FormToaGhe formGhe;
	private FormToaNam formNam;
	private FormListDontreo formDonTreo;
	private List<Chuyen> listChuyens;
	private Ga gaDi;
	private Ga gaDen;
	private LocalDate ngayDi;
	private ChiTietVeDao chiTietVeDao;
	private LocalDate ngayVe;
	private boolean isMotChieu;
	private GaDao gaDao;
	private VeDao veDao;
	private KhuyenMaiDao kmDao;
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private JPopupMenu menu;
	private PanelSearch search;
	private List<Ga> listGas;
	private ToaDao toaDao;
	private ChoNgoiDao choNgoiDao;
	private jFrameMuaVe frameMuaVe;
	private Map<String, Set<ChoNgoi>> listChoChon;
	private List<Model_InfoVe> listInfoVes;
	DefaultTableModel model;
	private boolean isJrVe = false;
	private boolean isJrDi = true;
	private JComboBox<String> cbDT;
	private Map<String, Set<String>> liscccd;
	private TaiKhoan taiKhoan;
	private HoaDon hoaDon;

	public FormChonTau(EntityManagerFactory emf, MainForm main, List<Chuyen> listChuyens, Ga gaDi, Ga gaDen,
			LocalDate ngayDi, LocalDate ngayVe, boolean isMotChieu, TaiKhoan taiKhoan) {
		this.emf = emf;
		this.main = main;
		this.taiKhoan = taiKhoan;
		this.listChuyens = listChuyens;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.ngayDi = ngayDi;
		this.ngayVe = ngayVe;
		this.isMotChieu = isMotChieu;
		this.chiTietVeDao = new ChiTietVeDao(emf);
		this.toaDao = new ToaDao(emf);
		this.gaDao = new GaDao(emf);
		this.veDao = new VeDao(emf);
		this.choNgoiDao = new ChoNgoiDao(emf);
		this.kmDao = new KhuyenMaiDao(emf);
		this.hoaDonDao = new HoaDonDao(emf);
		this.khachHangDao = new KhachHangDao(emf);
		this.listGas = gaDao.getAllGa();
		this.gaDau = gaDao.layGaDau();
		this.gaCuoi = gaDao.layGaCuoi();
		this.listChoChon = new HashMap<String, Set<ChoNgoi>>();
		this.liscccd = new HashMap<String, Set<String>>();
		this.listInfoVes = new ArrayList<Model_InfoVe>();
		initComponents();
		
		btnTimChuyen.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnTimChuyen.setIcon(new ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
		
		btnHuyCho.setBackground(new Color(231, 55, 55));
		btnHuyCho.setFont(new Font("SansSerif", 1, 18)); // NOI18N
		btnHuyCho.setIcon(new ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
		
		btnXacNhan.setFont(new Font("SansSerif", 1, 18)); // NOI18N
		btnXacNhan.setIcon(new ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
		
		btnXuLyTreo.setFont(new Font("SansSerif", 1, 18)); // NOI18N
		btnXuLyTreo.setIcon(new ImageIcon(getClass().getResource("/icon/xuly.png"))); // NOI18N
		
		model = (DefaultTableModel) tbListVe.getModel();
		cbDT = new JComboBox<String>();
		cbDT.addItem("Người lớn");
		cbDT.addItem("Trẻ em");
		cbDT.addItem("Sinh viên");
		cbDT.addItem("Người già");
		TableColumn col = tbListVe.getColumnModel().getColumn(2);
		cbDT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cbDTAction(e);
			}
		});

		col.setCellEditor(new DefaultCellEditor(cbDT));
		jpIfHanhTrinh.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Thông tin hành trình", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.black));
		jpIfHanhTrinh.setBackground(Color.white);
		jpIfHanhKhach.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Thông tin khách hàng", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.black));
		jpChieu.setBackground(Color.white);
		jpChieu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Chiều mua vé",
				0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.black));
		jpIfHanhKhach.setBackground(Color.white);
		jpIfve.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Thông tin vé",
				0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.black));
		jpIfve.setBackground(Color.white);
		jpChucNang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Nghiệp vụ",
				0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.black));
		jpChucNang.setBackground(Color.white);
		scp.setHorizontalScrollBar(new ScrollBar());
		spListKhoang.setHorizontalScrollBar(new ScrollBar2());
		scpTbVe.setVerticalScrollBar(new ScrollBar());
		tbListVe.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 14));
//        tbListVe.getColumnModel().getColumn(0).setCellRenderer(new TableFieldTextCellRender());
//        tbListVe.getColumnModel().getColumn(0).setCellEditor(new TabelFiledTextEditor());
		tbListVe.getTableHeader().setPreferredSize(new Dimension(30, 30));
		((DefaultTableCellRenderer) tbListVe.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		AddDataTau();
		menu = new JPopupMenu();
		search = new PanelSearch();
		menu.setBorder(BorderFactory.createLineBorder(new Color(176, 176, 176)));
		menu.add(search);
		menu.setFocusable(false);
		jrDi.setSelected(true);
		updateDataChuyen();
		jtCccd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				txtCccdReload(e);
			}
		});
	}

//    Du lieu toa
	private void AddDataToa(Model_Tau chuyen) {
		listIconTau.removeAll();
		setEventToa(new EventItemToa() {
			@Override
			public void itemClick(Component com, Toa toa) {
				setSelectedToa(com, toa, chuyen);
			}

		});
		IconToa dau = new IconToa();
		dau.setData(new ImageIcon(getClass().getResource("/icon/trainHead.png")), chuyen.getMaTau());
		listIconTau.add(dau);
		List<Toa> listToas = toaDao.getAllToaByMaChuyen(chuyen.getMaTau());
		for (Toa toa : listToas) {
			addItemToa(toa);
		}
		Component com = listIconTau.getComponent(listToas.get(0).getViTri());
		setSelectedToa(com, listToas.get(0), chuyen);
	}

	private void txtCccdReload(KeyEvent e) {
		String cc = jtCccd.getText();
		KhachHang kh = khachHangDao.getKhachHangByCCCD(cc);
		if (kh != null) {
			jtHoT.setText(kh.getHoTen());
			jtSdt.setText(kh.getSdt());
			jtEm.setText(kh.getEmail());
		}
	}

	public void addItemToa(Toa toa) {
		IconToa icontoa = new IconToa();
		icontoa.setData(toa.getViTri());
		icontoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					eventToa.itemClick(icontoa, toa);
				}
			}

		});
		listIconTau.add(icontoa);
		listIconTau.repaint();
		listIconTau.revalidate();
	}

	public void setSelectedToa(Component item, Toa toa, Model_Tau chuyen) {
		if (((IconToa) item).isSeleted())
			return;
		for (Component com : listIconTau.getComponents()) {
			IconToa i = (IconToa) com;
			if (i.isSeleted()) {
				i.setSeleted(false);
			}
		}
		((IconToa) item).setSeleted(true);
		int index = toa.getViTri();

		if (index < 5) {
			List<ChoNgoi> lisNgois = choNgoiDao.getAllChoNgoiTrongVTToa(gaDi.getId(), gaDen.getId(),
					chuyen.getChuyen().getMaChuyen(), index, true,chuyen.getMaTau());
			spListKhoang.setViewportView(
					formGhe = new FormToaGhe(chuyen, hoaDon, lisNgois, listChoChon, model, listInfoVes));
			lbifToa.setText("Toa " + index + ": Ngồi mền điều hòa");
		} else if (index < 8) {
			List<ChoNgoi> lisNgois = choNgoiDao.getAllChoNgoiTrongVTToa(gaDi.getId(), gaDen.getId(),
					chuyen.getChuyen().getMaChuyen(), index, true,chuyen.getMaTau());
			spListKhoang.setViewportView(
					formNam = new FormToaNam(6, chuyen, hoaDon, lisNgois, listChoChon, model, listInfoVes));
			lbifToa.setText("Toa " + index + ": Giường nằm khoang 6 điều hòa");
		} else {
			List<ChoNgoi> lisNgois = choNgoiDao.getAllChoNgoiTrongVTToa(gaDi.getId(), gaDen.getId(),
					chuyen.getChuyen().getMaChuyen(), index, true,chuyen.getMaTau());
			spListKhoang.setViewportView(
					formNam = new FormToaNam(4, chuyen, hoaDon, lisNgois, listChoChon, model, listInfoVes));
			lbifToa.setText("Toa " + index + ": Giường nằm khoang 4 điều hòa");
		}
	}

//    Du lieu tau
	private void AddDataTau() {
		setEvent(new EvenItemTau() {
			@Override
			public void itemClick(Component com, Model_Tau item) {
				if (setSelectedTau(com))
					AddDataToa(item);
			}

		});
		for (Chuyen chuyen : listChuyens) {
			if (gaDi.getId() < gaDen.getId())
				addItemTau(new Model_Tau(chuyen, gaDi, gaDen, gaDau));
			else
				addItemTau(new Model_Tau(chuyen, gaDi, gaDen, gaCuoi));
		}
		Component com = listTau.getComponent(0);
		((TauItem) com).setSeleted(true);
		AddDataToa(((TauItem) com).getData());

	}

	public void addItemTau(Model_Tau data) {
		TauItem item = new TauItem();
		item.setData(data);
		item.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					eventTau.itemClick(item, data);
				}
			}

		});
		listTau.add(item);
		listTau.repaint();
		listTau.revalidate();
	}

	public boolean setSelectedTau(Component item) {
		if (((TauItem) item).isSeleted())
			return false;
		for (Component com : listTau.getComponents()) {
			TauItem i = (TauItem) com;
			if (i.isSeleted())
				i.setSeleted(false);

		}
		((TauItem) item).setSeleted(true);
		return true;
	}

	private void updateDataChuyen() {
		jtGaDi.setText(gaDi.getTenGa());
		jtGaDen.setText(gaDen.getTenGa());
		if (isMotChieu) {
			rdMotChieu.setSelected(true);
			jrVe.setEnabled(false);
			jrDi.setSelected(true);
			dateVe.setEnabled(false);
		} else {
			rdHoiKhu.setSelected(true);
			jrVe.setEnabled(true);
			dateVe.setEnabled(true);
		}
		dateDi.setDate(Date.from(ngayDi.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		if (ngayVe != null)
			dateVe.setDate(Date.from(ngayVe.atStartOfDay(ZoneId.systemDefault()).toInstant()));

	}

	private List<DataSearch> search(String text) {
		int limitData = 4;
		List<DataSearch> list = new ArrayList<DataSearch>();
		if (text.equalsIgnoreCase("")) {
			return list;
		}
		for (Ga a : listGas) {
			if (a.getTenGa().toLowerCase().contains(text)) {
				list.add(new DataSearch(a.getTenGa()));
				if (list.size() == limitData) {
					break;
				}
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnGroup = new javax.swing.ButtonGroup();
		groupDiVe = new javax.swing.ButtonGroup();
		scp = new JScrollPane();
		listTau = new component.ListTau();
		listIconTau = new component.ListIconTau();
		formIfToa1 = new component.FormIfToa();
		jpIfToa = new JPanel();
		spListKhoang = new JScrollPane();
		lbNext = new JLabel();
		formTabelVe = new component.FormTabelVe();
		scpTbVe = new JScrollPane();
		tbListVe = new javax.swing.JTable();
		btnHuyCho = new javax.swing.JButton();
		jpIfHanhTrinh = new JPanel();
		lbGaDi = new JLabel();
		lbGaDen = new JLabel();
		rdMotChieu = new javax.swing.JRadioButton();
		rdHoiKhu = new javax.swing.JRadioButton();
		jtGaDi = new javax.swing.JTextField();
		jtGaDen = new javax.swing.JTextField();
		lbNgayDi = new JLabel();
		dateDi = new com.toedter.calendar.JDateChooser();
		lbVe = new JLabel();
		dateVe = new com.toedter.calendar.JDateChooser();
		btnTimChuyen = new javax.swing.JButton();
		jpIfHanhKhach = new JPanel();
		lbGaDi1 = new JLabel();
		jtCccd = new javax.swing.JTextField();
		lbGaDi2 = new JLabel();
		jtHoT = new javax.swing.JTextField();
		lbGaDi3 = new JLabel();
		lbGaDi4 = new JLabel();
		jtSdt = new javax.swing.JTextField();
		jtEm = new javax.swing.JTextField();
		jpChucNang = new JPanel();
		btnXuLyTreo = new javax.swing.JButton();
		btnXacNhan = new javax.swing.JButton();
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jpChieu = new JPanel();
		jrDi = new javax.swing.JRadioButton();
		jrVe = new javax.swing.JRadioButton();

		scp.setBorder(null);
		scp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		listTau.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));
		scp.setViewportView(listTau);

		jpIfToa.setOpaque(false);

		spListKhoang.setBackground(new Color(204, 204, 204));
		spListKhoang.setBorder(null);
		spListKhoang.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		lbNext.setIcon(new ImageIcon(getClass().getResource("/icon/next.png")));
		lbifToa = new JLabel();
		
				lbifToa.setFont(new Font("SansSerif", 0, 20)); // NOI18N
				lbifToa.setText("Toa 2: Ngồi mền điều hòa");

		GroupLayout formIfToa1Layout = new GroupLayout(formIfToa1);
		formIfToa1Layout.setHorizontalGroup(
			formIfToa1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(formIfToa1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(formIfToa1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbifToa, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
						.addGroup(formIfToa1Layout.createSequentialGroup()
							.addComponent(spListKhoang, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
							.addGap(1585)
							.addGroup(formIfToa1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbNext)
								.addComponent(jpIfToa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		formIfToa1Layout.setVerticalGroup(
			formIfToa1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(formIfToa1Layout.createSequentialGroup()
					.addGap(26)
					.addGroup(formIfToa1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(formIfToa1Layout.createSequentialGroup()
							.addGap(133)
							.addComponent(lbNext))
						.addGroup(formIfToa1Layout.createSequentialGroup()
							.addGap(32)
							.addComponent(jpIfToa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(61))
				.addGroup(formIfToa1Layout.createSequentialGroup()
					.addComponent(lbifToa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spListKhoang, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addContainerGap())
		);
		formIfToa1.setLayout(formIfToa1Layout);

		tbListVe.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		tbListVe.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "CCCD", "Họ tên", "Đối tượng", "Thông tin vé", "Giá vé", "Giảm đối tương", "Thành tiền" }) {
			boolean[] canEdit = new boolean[] { true, true, true, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tbListVe.setOpaque(false);
		tbListVe.setRowHeight(30);
		tbListVe.setSelectionBackground(new Color(204, 204, 204));
		tbListVe.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tbListVeMouseClicked(evt);
			}
		});
		scpTbVe.setViewportView(tbListVe);

		btnHuyCho.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnHuyCho.setText("Hủy chổ");
		btnHuyCho.setPreferredSize(new Dimension(96, 55));
		btnHuyCho.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnHuyChoMouseClicked(evt);
			}
		});

		GroupLayout formTabelVeLayout = new GroupLayout(formTabelVe);
		formTabelVeLayout.setHorizontalGroup(
			formTabelVeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formTabelVeLayout.createSequentialGroup()
					.addGroup(formTabelVeLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(formTabelVeLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(btnHuyCho, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addComponent(scpTbVe, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
					.addContainerGap())
		);
		formTabelVeLayout.setVerticalGroup(
			formTabelVeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formTabelVeLayout.createSequentialGroup()
					.addComponent(scpTbVe, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnHuyCho, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		formTabelVe.setLayout(formTabelVeLayout);

		lbGaDi.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDi.setText("Ga đi");

		lbGaDen.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDen.setText("Ga đến");

		btnGroup.add(rdMotChieu);
		rdMotChieu.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		rdMotChieu.setText("Một chiều");
		rdMotChieu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				rdMotChieuMouseClicked(evt);
			}
		});
		rdMotChieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rdMotChieuActionPerformed(evt);
			}
		});

		btnGroup.add(rdHoiKhu);
		rdHoiKhu.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		rdHoiKhu.setText("Khứ hồi");
		rdHoiKhu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				rdHoiKhuMouseClicked(evt);
			}
		});

		jtGaDi.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtGaDi.setMinimumSize(new Dimension(64, 40));
		jtGaDi.setPreferredSize(new Dimension(64, 40));
		jtGaDi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jtGaDiMouseClicked(evt);
			}
		});
		jtGaDi.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				jtGaDiKeyReleased(evt);
			}
		});

		jtGaDen.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtGaDen.setMinimumSize(new Dimension(64, 40));
		jtGaDen.setPreferredSize(new Dimension(64, 40));
		jtGaDen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jtGaDenMouseClicked(evt);
			}
		});
		jtGaDen.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				jtGaDenKeyReleased(evt);
			}
		});

		lbNgayDi.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbNgayDi.setText("Ngày về");

		dateDi.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		dateDi.setPreferredSize(new Dimension(88, 40));

		lbVe.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbVe.setText("Ngày đi");

		dateVe.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		dateVe.setPreferredSize(new Dimension(88, 40));

		btnTimChuyen.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnTimChuyen.setText("Tìm");
		btnTimChuyen.setBorder(null);
		btnTimChuyen.setPreferredSize(new Dimension(75, 55));
		btnTimChuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnTimChuyenActionPerformed(evt);
			}
		});

		GroupLayout jpIfHanhTrinhLayout = new GroupLayout(jpIfHanhTrinh);
		jpIfHanhTrinhLayout.setHorizontalGroup(
			jpIfHanhTrinhLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jpIfHanhTrinhLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jpIfHanhTrinhLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(rdMotChieu)
							.addGap(21)
							.addComponent(rdHoiKhu))
						.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
								.addComponent(lbGaDen)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jtGaDen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
								.addComponent(lbGaDi)
								.addGap(18)
								.addComponent(jtGaDi, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
								.addComponent(lbNgayDi)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(dateVe, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
								.addComponent(lbVe)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(dateDi, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(Alignment.LEADING, jpIfHanhTrinhLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(btnTimChuyen, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		jpIfHanhTrinhLayout.setVerticalGroup(
			jpIfHanhTrinhLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpIfHanhTrinhLayout.createSequentialGroup()
					.addGap(0)
					.addGroup(jpIfHanhTrinhLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDi)
						.addComponent(jtGaDi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(jpIfHanhTrinhLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDen)
						.addComponent(jtGaDen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(jpIfHanhTrinhLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdMotChieu)
						.addComponent(rdHoiKhu))
					.addGap(18)
					.addGroup(jpIfHanhTrinhLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(jpIfHanhTrinhLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(dateDi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dateVe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(jpIfHanhTrinhLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(lbVe)
							.addGap(25)
							.addComponent(lbNgayDi)))
					.addGap(18)
					.addComponent(btnTimChuyen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(198))
		);
		jpIfHanhTrinh.setLayout(jpIfHanhTrinhLayout);

		lbGaDi1.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDi1.setText("CCCD");

		jtCccd.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtCccd.setMinimumSize(new Dimension(64, 40));
		jtCccd.setPreferredSize(new Dimension(64, 40));

		lbGaDi2.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDi2.setText("Họ tên");

		jtHoT.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtHoT.setMinimumSize(new Dimension(64, 40));
		jtHoT.setPreferredSize(new Dimension(64, 40));

		lbGaDi3.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDi3.setText("Số điện thoại");

		lbGaDi4.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbGaDi4.setText("Email");

		jtSdt.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtSdt.setMinimumSize(new Dimension(64, 40));
		jtSdt.setPreferredSize(new Dimension(64, 40));

		jtEm.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		jtEm.setMinimumSize(new Dimension(64, 40));
		jtEm.setPreferredSize(new Dimension(64, 40));

		GroupLayout jpIfHanhKhachLayout = new GroupLayout(jpIfHanhKhach);
		jpIfHanhKhachLayout.setHorizontalGroup(
			jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpIfHanhKhachLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(jpIfHanhKhachLayout.createSequentialGroup()
							.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbGaDi2)
								.addComponent(lbGaDi1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jtHoT, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtCccd, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
						.addGroup(jpIfHanhKhachLayout.createSequentialGroup()
							.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbGaDi3)
								.addComponent(lbGaDi4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jtEm, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(jtSdt, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
					.addGap(10))
		);
		jpIfHanhKhachLayout.setVerticalGroup(
			jpIfHanhKhachLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpIfHanhKhachLayout.createSequentialGroup()
					.addGap(0)
					.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDi1)
						.addComponent(jtCccd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDi2)
						.addComponent(jtHoT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDi3)
						.addComponent(jtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(jpIfHanhKhachLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbGaDi4)
						.addComponent(jtEm, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		jpIfHanhKhach.setLayout(jpIfHanhKhachLayout);

		btnXuLyTreo.setFont(new Font("SansSerif", Font.PLAIN, 15)); // NOI18N
		btnXuLyTreo.setText("Xử lý đơn tạm");
		btnXuLyTreo.setBorder(null);
		btnXuLyTreo.setMinimumSize(new Dimension(66, 45));
		btnXuLyTreo.setPreferredSize(new Dimension(66, 45));
		btnXuLyTreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnXuLyTreoActionPerformed(evt);
			}
		});

		btnXacNhan.setFont(new Font("SansSerif", Font.PLAIN, 15)); // NOI18N
		btnXacNhan.setText("Xác nhận mua vé");
		btnXacNhan.setActionCommand("");
		btnXacNhan.setBorder(null);
		btnXacNhan.setMinimumSize(new Dimension(66, 45));
		btnXacNhan.setPreferredSize(new Dimension(66, 45));
		btnXacNhan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnXacNhanMouseClicked(evt);
			}
		});

		GroupLayout jpChucNangLayout = new GroupLayout(jpChucNang);
		jpChucNangLayout.setHorizontalGroup(
			jpChucNangLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpChucNangLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(btnXuLyTreo, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(145)
					.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		jpChucNangLayout.setVerticalGroup(
			jpChucNangLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jpChucNangLayout.createSequentialGroup()
					.addGroup(jpChucNangLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnXuLyTreo, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
					.addContainerGap())
		);
		jpChucNang.setLayout(jpChucNangLayout);
		
		groupDiVe.add(jrDi);
		jrDi.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jrDi.setText("Chiều đi");
		jrDi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jrDiMouseClicked(evt);
			}
		});

		groupDiVe.add(jrVe);
		jrVe.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jrVe.setText("Chiều về");
		jrVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jrVeActionPerformed(evt);
			}
		});

		GroupLayout jpChieuLayout = new GroupLayout(jpChieu);
		jpChieuLayout.setHorizontalGroup(
			jpChieuLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpChieuLayout.createSequentialGroup()
					.addGap(256)
					.addComponent(jrDi)
					.addGap(142)
					.addComponent(jrVe)
					.addContainerGap(263, Short.MAX_VALUE))
		);
		jpChieuLayout.setVerticalGroup(
			jpChieuLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jpChieuLayout.createSequentialGroup()
					.addGroup(jpChieuLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jrDi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(jrVe, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
					.addContainerGap())
		);
		jpChieu.setLayout(jpChieuLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		
		lblNewLabel = new JLabel("Ghế đang chọn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(225, 0, 0));
		
		lblGhBn = new JLabel("Ghế đã bán");
		lblGhBn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 157, 79));
		
		lblToaangChn = new JLabel("Toa đang chọn");
		lblToaangChn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jpIfve = new JPanel();
		lbTauChuyen = new JLabel();
		lbTTHoTen = new JLabel();
		lbTTCCCD = new JLabel();
		lbThoiGianLen = new JLabel();
		lbToaCho = new JLabel();
		lbMoTaVe = new JLabel();
		
				jpIfve.setToolTipText("SE1 Long Khánh-Sài Gòn");
				jpIfve.setFont(new Font("SansSerif", 0, 14)); // NOI18N
				
						lbTTHoTen.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
						lbTTHoTen.setText(" ");
						
						lbTTCCCD.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
						lbTTCCCD.setText(" ");
						
						lbTauChuyen.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
						lbTauChuyen.setText(" ");
						
								lbThoiGianLen.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
								lbThoiGianLen.setText(" ");
								
										lbToaCho.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
										lbToaCho.setText(" ");
										
												lbMoTaVe.setFont(new Font("SansSerif", Font.PLAIN, 13)); // NOI18N
												lbMoTaVe.setText(" ");
												
														GroupLayout jpIfveLayout = new GroupLayout(jpIfve);
														jpIfve.setLayout(jpIfveLayout);
																jpIfveLayout.setHorizontalGroup(jpIfveLayout.createParallelGroup(Alignment.LEADING)
																		.addGroup(jpIfveLayout.createSequentialGroup().addGap(17, 17, 17)
																				.addGroup(jpIfveLayout.createParallelGroup(Alignment.TRAILING)
																						.addComponent(lbTTHoTen, Alignment.LEADING)
																						.addComponent(lbTTCCCD, Alignment.LEADING)
																						.addComponent(lbThoiGianLen, Alignment.LEADING)
																						.addComponent(lbToaCho, Alignment.LEADING)
																						.addComponent(lbMoTaVe, Alignment.LEADING)
																						.addComponent(lbTauChuyen, Alignment.LEADING))
																				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
																jpIfveLayout.setVerticalGroup(jpIfveLayout.createParallelGroup(Alignment.LEADING)
																		.addGroup(jpIfveLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(lbTauChuyen)
																				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbTTHoTen)
																				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbTTCCCD)
																				.addPreferredGap(ComponentPlacement.UNRELATED)
																				.addComponent(lbThoiGianLen)
																				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbToaCho)
																				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbMoTaVe)
																				.addContainerGap(31, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(scp, GroupLayout.PREFERRED_SIZE, 704, GroupLayout.PREFERRED_SIZE)
								.addComponent(listIconTau, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addGap(50)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(81)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(82)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(lblGhBn, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblToaangChn, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jpIfHanhKhach, GroupLayout.PREFERRED_SIZE, 303, Short.MAX_VALUE)
								.addComponent(jpIfve, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jpIfHanhTrinh, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(formIfToa1, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE)
								.addComponent(jpChieu, 0, 0, Short.MAX_VALUE)
								.addComponent(jpChucNang, GroupLayout.PREFERRED_SIZE, 783, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formTabelVe, GroupLayout.PREFERRED_SIZE, 484, Short.MAX_VALUE)))
					.addContainerGap(403, GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(scp, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listIconTau, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGhBn, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblToaangChn, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
							.addComponent(jpIfHanhKhach, GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jpIfve, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addComponent(jpIfHanhTrinh, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
							.addComponent(formIfToa1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jpChieu, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jpChucNang, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addComponent(formTabelVe, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
					.addGap(634))
		);
		this.setLayout(layout);
	}

	private void cbDTAction(ActionEvent e) {
	    int index = tbListVe.getSelectedRow();
	    if (index < 0) return;
		Model_InfoVe veif = listInfoVes.get(index);

	    String doiTuong = model.getValueAt(index, 2).toString();

	    if (doiTuong.equalsIgnoreCase("Trẻ em")) {
	        DateTimeFormatter formatterHD = DateTimeFormatter.ofPattern("ddMMyyyy");
	        JDialog dialog = new JDialog();

	        JDateChooser dateChooser = new JDateChooser();
	        dialog.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                model.setValueAt("", index, 0); 
	                String tien = model.getValueAt(index, 4).toString(); 
	                model.setValueAt(tien, index, 6); 
	                model.setValueAt("Người lớn", index, 2); 
	            }
	        });

	        dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
	            @Override
	            public void propertyChange(PropertyChangeEvent evt) {
	                if ("date".equals(evt.getPropertyName())) {
	                    LocalDate dateChon = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	                    int tuoi = LocalDate.now().getYear() - dateChon.getYear();

	                    if (tuoi < 6) {
	                        JOptionPane.showMessageDialog(null, "Trẻ dưới 6 tuổi được miễn phí vé.");
	                        model.setValueAt("Trẻ em", index, 2); 
	                        model.setValueAt(model.getValueAt(index, 4), index, 5); 
	                        model.setValueAt(0, index, 6); 
	                    } else if (tuoi > 13 && tuoi <= 16) {
	                        JOptionPane.showMessageDialog(null, "Trẻ em từ 14-16 tuổi không nằm trong chương trình áp dụng.");
	                        model.setValueAt("Trẻ em", index, 2); 
	                        model.setValueAt(0, index, 5); 
	                        String tien = model.getValueAt(index, 4).toString(); 
	                        model.setValueAt(tien, index, 6); 
	                    } else if(tuoi >= 6 && tuoi<=13){
	                    	Object giaGocObj = model.getValueAt(index, 4);
	                        int giaGoc = 0;
	                        
	                        if (giaGocObj instanceof Integer) {
	                            giaGoc = (Integer) giaGocObj;  
	                        } else if (giaGocObj instanceof String) {
	                            giaGoc = Integer.parseInt((String) giaGocObj); 
	                        }

	                        KhuyenMai km = kmDao.layKhuyenMaiTotNhatBangLoai(doiTuong);

	                        if (km != null) {
	                            JOptionPane.showMessageDialog(null, "Trẻ em từ 6 đến 13 tuổi được giảm 25% giá vé");
	                            int tienGiam = (int) (giaGoc * km.getChietKhau());  
	                            int giaSauGiam = giaGoc - tienGiam;  
	                            model.setValueAt("Trẻ em", index, 2);  
	                            model.setValueAt(tienGiam, index, 5);  
	                            model.setValueAt(giaSauGiam, index, 6);
	                        }
	                   }
	                    dialog.setVisible(false);
	                    dialog.dispose();
	                }
	            }
	        });
	        dialog.getContentPane().add(dateChooser);
	        dialog.setLocationRelativeTo(cbDT);
	        dialog.setModal(true);
	        dialog.pack();
	        dialog.setVisible(true);
	    }else if(doiTuong.equalsIgnoreCase("Người già")) {
	    	Object giaGocObj = model.getValueAt(index, 4);
            int giaGoc = 0;
            
            if (giaGocObj instanceof Integer) {
                giaGoc = (Integer) giaGocObj;  
            } else if (giaGocObj instanceof String) {
                giaGoc = Integer.parseInt((String) giaGocObj); 
            }

            KhuyenMai km = kmDao.layKhuyenMaiTotNhatBangLoai(doiTuong);

            if (km != null) {
                JOptionPane.showMessageDialog(null, "Người già được giảm 25% giá vé.");
                int tienGiam = (int) (giaGoc * km.getChietKhau());  
                int giaSauGiam = giaGoc - tienGiam;  
                model.setValueAt("Người già", index, 2);  
                model.setValueAt(tienGiam, index, 5);  
                model.setValueAt(giaSauGiam, index, 6);
            }
	    }else if(doiTuong.equalsIgnoreCase("Sinh viên")) {
	    	Object giaGocObj = model.getValueAt(index, 4);
            int giaGoc = 0;
            
            if (giaGocObj instanceof Integer) {
                giaGoc = (Integer) giaGocObj;  
            } else if (giaGocObj instanceof String) {
                giaGoc = Integer.parseInt((String) giaGocObj); 
            }

            KhuyenMai km = kmDao.layKhuyenMaiTotNhatBangLoai(doiTuong);

            if (km != null) {
                JOptionPane.showMessageDialog(null, "Sinh viên được giảm 10% giá vé");
                int tienGiam = (int) (giaGoc * km.getChietKhau());  
                int giaSauGiam = giaGoc - tienGiam;  
                model.setValueAt("Sinh viên", index, 2);  
                model.setValueAt(tienGiam, index, 5);  
                model.setValueAt(giaSauGiam, index, 6);
            }
	    }
	}

	private void rdMotChieuActionPerformed(ActionEvent evt) {// GEN-FIRST:event_rdMotChieuActionPerformed
		dateVe.setEnabled(false);
	}// GEN-LAST:event_rdMotChieuActionPerformed

	private void btnTimChuyenActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnTimChuyenActionPerformed
		String gaDi = jtGaDi.getText();
		String gaDen = jtGaDen.getText();
		Ga ga1 = gaDao.getGaByTen(gaDi);
		Ga ga2 = gaDao.getGaByTen(gaDen);
		if (ga1 == null) {
			JOptionPane.showMessageDialog(null, "Ga không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (ga2 == null) {
			JOptionPane.showMessageDialog(null, "Ga không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (dateDi.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Chưa chọn ngày đi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (dateVe.getDate() == null && rdHoiKhu.isSelected()) {
			JOptionPane.showMessageDialog(null, "Chưa chọn ngày về", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		List<String> listTuyens = new TuyenDao(emf).layTuyenChuaGa(ga1.getId(), ga2.getId());
		if (listTuyens.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không có tàu đi tuyến của bạn", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		LocalDate ngDi = dateDi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate ngVe = null;
		if (rdHoiKhu.isSelected()) {
			ngVe = dateVe.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (!ngVe.isAfter(ngDi)) {
				JOptionPane.showMessageDialog(null, "Ngày về phải sau ngày đi", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		List<Chuyen> listChuyenDis = new ArrayList<Chuyen>();
		for (String maTuyen : listTuyens) {
			List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngDi, ga1.getId() < ga2.getId(), maTuyen);
			listChuyenDis.addAll(listtam);
		}
		if (listChuyenDis.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến phù hợp!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		List<Chuyen> listChuyenVes = new ArrayList<Chuyen>();
		if (ngVe != null) {
			for (String maTuyen : listTuyens) {
				List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngVe, ga1.getId() > ga2.getId(), maTuyen);
				listChuyenVes.addAll(listtam);
			}
			if (listChuyenVes.size() == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến về!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}

		listTau.removeAll();
		this.gaDi = ga1;
		this.gaDen = ga2;
		this.listChuyens = listChuyenDis;
		this.ngayDi = ngDi;
		this.ngayVe = ngVe;
		this.isMotChieu = rdMotChieu.isSelected();
		jrDi.setSelected(true);
		isJrDi = true;
		isJrVe = false;
		AddDataTau();
		updateDataChuyen();

	}// GEN-LAST:event_btnTimChuyenActionPerformed

	private void btnXuLyTreoActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnXuLyTreoActionPerformed
		if (formDonTreo == null || !formDonTreo.isVisible()) {
			formDonTreo = new FormListDontreo(emf);
			formDonTreo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowDeactivated(WindowEvent e) {
					if (formDonTreo.isClick()) {
						hoaDon = formDonTreo.getHoaDon();
						System.out.println(hoaDon.getListVes().size());
						XoaTrang();
						addDataHoaDon();
					}

				}
			});
			formDonTreo.setVisible(true);
		}
	}// GEN-LAST:event_btnXuLyTreoActionPerformed

	private void rdHoiKhuMouseClicked(MouseEvent evt) {// GEN-FIRST:event_rdHoiKhuMouseClicked
		dateVe.setEnabled(true);
	}// GEN-LAST:event_rdHoiKhuMouseClicked

	private void rdMotChieuMouseClicked(MouseEvent evt) {// GEN-FIRST:event_rdMotChieuMouseClicked
		jrVe.setEnabled(false);
		isMotChieu = true;
		jrDi.setSelected(true);
	}// GEN-LAST:event_rdMotChieuMouseClicked

	private void jtGaDiMouseClicked(MouseEvent evt) {// GEN-FIRST:event_jtGaDiMouseClicked
		String text = jtGaDi.getText().toLowerCase();
		search.setData(search(text));
		search.addEventClick(new EvenItemGaClick() {
			public void itemClick(DataSearch data) {
				menu.setVisible(false);
				jtGaDi.setText(data.getText());
			}
		});
		if (search.getItemSize() > 0) {
			menu.show(jtGaDi, 0, jtGaDi.getHeight());
			menu.setPopupSize(jtGaDi.getWidth(), (search.getItemSize() * 45));
		}
	}// GEN-LAST:event_jtGaDiMouseClicked

	private void jtGaDenKeyReleased(KeyEvent evt) {// GEN-FIRST:event_jtGaDenKeyReleased
		search.addEventClick(new EvenItemGaClick() {
			public void itemClick(DataSearch data) {
				menu.setVisible(false);
				jtGaDen.setText(data.getText());
			}
		});
		String text = jtGaDen.getText().toLowerCase();
		search.setData(search(text));
		if (search.getItemSize() >= 0) {
			menu.show(jtGaDen, 0, jtGaDen.getHeight());
			menu.setPopupSize(jtGaDen.getWidth(), (search.getItemSize() * 45));
		}
	}// GEN-LAST:event_jtGaDenKeyReleased

	private void jtGaDenMouseClicked(MouseEvent evt) {// GEN-FIRST:event_jtGaDenMouseClicked
		String text = jtGaDen.getText().toLowerCase();
		search.setData(search(text));
		search.addEventClick(new EvenItemGaClick() {
			public void itemClick(DataSearch data) {
				menu.setVisible(false);
				jtGaDen.setText(data.getText());
			}
		});
		if (search.getItemSize() > 0) {
			menu.show(jtGaDen, 0, jtGaDen.getHeight());
			menu.setPopupSize(jtGaDen.getWidth(), (search.getItemSize() * 45));
		}
	}// GEN-LAST:event_jtGaDenMouseClicked

	private void jtGaDiKeyReleased(KeyEvent evt) {// GEN-FIRST:event_jtGaDiKeyReleased
		search.addEventClick(new EvenItemGaClick() {
			public void itemClick(DataSearch data) {
				menu.setVisible(false);
				jtGaDi.setText(data.getText());
			}
		});
		String text = jtGaDi.getText().toLowerCase();
		search.setData(search(text));
		if (search.getItemSize() >= 0) {
			menu.show(jtGaDi, 0, jtGaDi.getHeight());
			menu.setPopupSize(jtGaDi.getWidth(), (search.getItemSize() * 45));
		}
	}// GEN-LAST:event_jtGaDiKeyReleased

	
	private void btnXacNhanMouseClicked(MouseEvent evt) {
	    if (frameMuaVe == null || !frameMuaVe.isVisible()) {
	        if (listInfoVes.size() == 0) {
	            JOptionPane.showMessageDialog(null, "Bạn chưa chọn chổ ngồi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	        if (hoaDon == null) {
	            LocalDateTime currentDateTime = LocalDateTime.now();
	            DateTimeFormatter formatterHD = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
	            DateTimeFormatter formatterVe = DateTimeFormatter.ofPattern("HHmmddMMyyyy");
	            String mave = "";
	            String dem = "";
	            String cccd = jtCccd.getText().trim();
	            String hoTen = jtHoT.getText().trim();
	            String doiTuong = "";
	            String sdt = jtSdt.getText().trim();
	            String email = jtEm.getText().trim();

	            KhachHang kh = new KhachHang(cccd, sdt, hoTen, email);

	            // Kiểm tra thông tin khách hàng trước khi tiếp tục
	            if (!kiemTraThongTinKhachHang(kh, "khách hàng")) {
	                return;
	            }

	            String maNhanVien = taiKhoan.getNhanVien().getMaNhanVien();
	            String maHD = "HD" + currentDateTime.format(formatterHD) + maNhanVien.substring(maNhanVien.length() - 4);
	            hoaDon = new HoaDon(maHD, LocalTime.now(), LocalDate.now(), true);
	            hoaDon.setKhachHang(kh);

	            // Khởi tạo danh sách khuyến mãi
	            KhuyenMai km = kmDao.layKhuyenMaiTotNhatBangLoai(listInfoVes.size());
	            Set<KhuyenMai> listKM = null;
	            if (km != null) {
	                listKM = new HashSet<KhuyenMai>();
	                listKM.add(km);
	            }
	            km = kmDao.layKhuyenMaiTotNhatBangLoai("Vé");
	            if (km != null) {
	                if (listKM != null)
	                    listKM.add(km);
	                else {
	                    listKM = new HashSet<KhuyenMai>();
	                    listKM.add(km);
	                }
	            }

	            hoaDon.setLisKhuyenMais(listKM);
	            hoaDon.setNhanVien(taiKhoan.getNhanVien());

	            // Kiểm tra và khởi tạo danh sách vé nếu chưa có
	            List<Ve> listVe = new ArrayList<Ve>();
	            if (hoaDon.getListVes() == null) {
	                hoaDon.setListVes(listVe);  // Khởi tạo danh sách vé nếu null
	            }

	            List<Ve> listVeMa = veDao.layVeThuocMa(currentDateTime.format(formatterVe));
	            for (int i = 0; i < model.getRowCount(); i++) {
	                cccd = model.getValueAt(i, 0).toString();
	                hoTen = model.getValueAt(i, 1).toString();
	                doiTuong = model.getValueAt(i, 2).toString();
	                kh = khachHangDao.getKhachHangByCCCD(cccd);

	                if (kh == null) {
	                    kh = new KhachHang(cccd, hoTen, doiTuong);
	                    if (!kiemTraThongTinKhachHang(kh, "vé")) {
	                        tbListVe.setRowSelectionInterval(i, i);
	                        return;
	                    }
	                    khachHangDao.addKhachHang(kh); // Lưu khách hàng nếu hợp lệ
	                }

	                dem = ((listVeMa.size() + i) / 100 > 0) ? "" + (listVeMa.size() + i)
	                        : ((listVeMa.size() + i) / 10 > 0) ? "0" + (listVeMa.size() + i)
	                        : "00" + (listVeMa.size() + i);
	                mave = currentDateTime.format(formatterVe) + dem + maNhanVien.substring(maNhanVien.length() - 4);
	                Ve ve = new Ve(mave, listInfoVes.get(i).getChuyen().getDateLenTau(), true);
	                km = kmDao.layKhuyenMaiTotNhatBangLoai(doiTuong);

	                Set<ChiTietVe> listCTV = new HashSet<ChiTietVe>();
	                listCTV.add(new ChiTietVe(ve, listInfoVes.get(i).getChuyen().getGaDi(), true));
	                listCTV.add(new ChiTietVe(ve, listInfoVes.get(i).getChuyen().getGaDen(), false));
	                ve.setLisChiTietVes(listCTV);
	                ve.setKhuyenMai(km);
	                ve.setHoaDon(hoaDon);
	                ve.setKhachHang(kh);
	                ve.setChuyen(listInfoVes.get(i).getChuyen().getChuyen());
	                ve.setChoNgoi(listInfoVes.get(i).getChoNgoi());
	                listVe.add(ve);
	                dem = "";
	                mave = "";
	            }
	            hoaDon.setListVes(listVe);
	        }

	        if (hoaDon != null && !hoaDon.isTrangThai()) {
	            LocalDateTime currentDateTime = LocalDateTime.now();
	            DateTimeFormatter formatterVe = DateTimeFormatter.ofPattern("HHmmddMMyyyy");
	            String maNhanVien = taiKhoan.getNhanVien().getMaNhanVien();
	            String cccd = "";
	            String hoTen = "";
	            String doiTuong = "";
	            KhachHang kh = null;
	            String mave = "";
	            String dem = "";
	            List<Ve> listVeMa = veDao.layVeThuocMa(currentDateTime.format(formatterVe));
	            for (int i = hoaDon.getListVes().size(); i < model.getRowCount(); i++) {
	                cccd = model.getValueAt(i, 0).toString();
	                hoTen = model.getValueAt(i, 1).toString();
	                doiTuong = model.getValueAt(i, 2).toString();
	                kh = khachHangDao.getKhachHangByCCCD(cccd);
	                if (cccd.equalsIgnoreCase(hoaDon.getKhachHang().getCccd())) {
	                    hoaDon.getKhachHang().setDoiTuong(doiTuong);
	                }
	                KhuyenMai km = null;
	                if (kh == null) {
	                    kh = new KhachHang(cccd, hoTen, doiTuong);
	                    if (!kiemTraThongTinKhachHang(kh, "vé")) {
	                        tbListVe.setRowSelectionInterval(i, i);
	                        return;
	                    }
	                    khachHangDao.addKhachHang(kh); // Lưu khách hàng mới nếu hợp lệ
	                }
	                if (checkDataVe(kh) > 0) {
	                    tbListVe.setRowSelectionInterval(i, i);
	                    showMessageValue(checkDataVe(kh), "vé");
	                    return;
	                }
	                dem = ((listVeMa.size() + i) / 100 > 0) ? "" + (listVeMa.size() + i)
	                        : ((listVeMa.size() + i) / 10 > 0) ? "0" + (listVeMa.size() + i)
	                        : "00" + (listVeMa.size() + i);
	                mave = currentDateTime.format(formatterVe) + dem + maNhanVien.substring(maNhanVien.length() - 4);
	                Ve ve = new Ve(mave, listInfoVes.get(i).getChuyen().getDateLenTau(), true);
	                km = kmDao.layKhuyenMaiTotNhatBangLoai(doiTuong);

	                Set<ChiTietVe> listCTV = new HashSet<ChiTietVe>();
	                listCTV.add(new ChiTietVe(ve, listInfoVes.get(i).getChuyen().getGaDi(), true));
	                listCTV.add(new ChiTietVe(ve, listInfoVes.get(i).getChuyen().getGaDen(), false));
	                ve.setLisChiTietVes(listCTV);
	                ve.setKhuyenMai(km);
	                ve.setHoaDon(hoaDon);
	                ve.setKhachHang(kh);
	                ve.setChuyen(listInfoVes.get(i).getChuyen().getChuyen());
	                ve.setChoNgoi(listInfoVes.get(i).getChoNgoi());
	                hoaDon.getListVes().add(ve);
	                dem = "";
	                mave = "";
	            }
	        }

	        if (frameMuaVe == null) {
	            frameMuaVe = new jFrameMuaVe(emf, hoaDon);
	            frameMuaVe.addWindowListener(new WindowAdapter() {
	                @Override
	                public void windowDeactivated(WindowEvent e) {
	                    if (frameMuaVe.isAddHoaDon()) {
	                        XoaTrang();
	                        hoaDon = null;
	                        AddDataTau();
	                    }
	                }
	            });
	            frameMuaVe.setVisible(true);
	        } else {
	            frameMuaVe.setHoadon(hoaDon);
	            frameMuaVe.setVisible(true);
	        }
	    }
	}

	
	// Thêm phương thức kiểm tra
	private boolean kiemTraThongTinKhachHang(KhachHang khachHang, String loai) {
	    int check = checkData(khachHang);
	    if (check > 0) {
	        showMessageValue(check, loai);
	        return false;
	    }
	    return true;
	}


	private void showMessageValue(int check, String loai) {
	    switch (check) {
	        case 1:
	            JOptionPane.showMessageDialog(null, "CCCD phải là 12 chữ số", "Lỗi Thông tin " + loai,
	                    JOptionPane.INFORMATION_MESSAGE);
	            break;
	        case 2:
	            JOptionPane.showMessageDialog(null, "Họ tên không chứa số và ký tự đặc biệt", "Lỗi Thông tin " + loai,
	                    JOptionPane.INFORMATION_MESSAGE);
	            break;
	        case 3:
	            JOptionPane.showMessageDialog(null, "Số điện thoại phải là 10 chữ số và bắt đầu bằng 0", "Lỗi Thông tin " + loai,
	                    JOptionPane.INFORMATION_MESSAGE);
	            break;
	        case 4:
	            JOptionPane.showMessageDialog(null, "Email không đúng định dạng (example@gmail.com)", "Lỗi Thông tin " + loai,
	                    JOptionPane.INFORMATION_MESSAGE);
	            break;
	    }
	}

//	private void addDataHoaDon() {
//		jtCccd.setText(hoaDon.getKhachHang().getCccd());
//		jtHoT.setText(hoaDon.getKhachHang().getHoTen());
//		jtSdt.setText(hoaDon.getKhachHang().getSdt());
//		jtEm.setText(hoaDon.getKhachHang().getEmail());
//		for (Ve ve : hoaDon.getListVes()) {
//			String maChuyen = ve.getChuyen().getMaChuyen();
//			if (!listChoChon.containsKey(maChuyen)) {
//				Set<ChoNgoi> listCN = new HashSet<ChoNgoi>();
//				listCN.add(ve.getChoNgoi());
//				listChoChon.put(maChuyen, listCN);
//			} else {
//				listChoChon.get(maChuyen).add(ve.getChoNgoi());
//			}
//		}
//		for (ChiTietVe ctv : hoaDon.getListVes().get(0).getLisChiTietVes()) {
//			if (ctv.isChieu())
//				gaDi = ctv.getGa();
//			else
//				gaDen = ctv.getGa();
//		}
//		isMotChieu = true;
//		List<String> listTuyens = new TuyenDao(emf).layTuyenChuaGa(gaDi.getId(), gaDen.getId());
//		List<Chuyen> listChuyenVes = new ArrayList<Chuyen>();
//		ngayDi = hoaDon.getListVes().get(0).getChuyen().getNgayKhoiHanh();
//		for (String maTuyen : listTuyens) {
//			List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngayDi, gaDi.getId() < gaDen.getId(), maTuyen);
//			listChuyenVes.addAll(listtam);
//		}
//		this.listChuyens = listChuyenVes;
//		createModel_IfVes();
//		updateDataChuyen();
//		AddDataTau();
//	}

	private void addDataHoaDon() {
	    // Kiểm tra nếu hoaDon và thông tin khách hàng là hợp lệ
	    if (hoaDon.getKhachHang() != null && hoaDon.getKhachHang().getCccd() != null) {
	        KhachHangDao khachHangDao = new KhachHangDao(emf);
	        KhachHang existingKhachHang = khachHangDao.getKhachHangByCCCD(hoaDon.getKhachHang().getCccd());

	        // Nếu khách hàng chưa có trong DB, thêm khách hàng mới vào DB
	        if (existingKhachHang == null) {
	            boolean isAdded = khachHangDao.addKhachHang(hoaDon.getKhachHang());
	            if (!isAdded) {
	                // Xử lý nếu thêm khách hàng không thành công
	                System.out.println("Khách hàng đã tồn tại hoặc có lỗi khi thêm khách hàng.");
	                return; // Dừng việc xử lý nếu không thể thêm khách hàng
	            }
	        } else {
	            // Nếu khách hàng đã có, lấy lại thông tin khách hàng từ DB
	            hoaDon.setKhachHang(existingKhachHang);
	        }
	    }

	    // Nếu danh sách vé trong hóa đơn là null, khởi tạo danh sách mới
	    if (hoaDon.getListVes() == null) {
	        hoaDon.setListVes(new ArrayList<Ve>());
	    }

	    // Xử lý các vé trong danh sách hoaDon
	    for (Ve ve : hoaDon.getListVes()) {
	        String maChuyen = ve.getChuyen().getMaChuyen();
	        if (!listChoChon.containsKey(maChuyen)) {
	            Set<ChoNgoi> listCN = new HashSet<ChoNgoi>();
	            listCN.add(ve.getChoNgoi());
	            listChoChon.put(maChuyen, listCN);
	        } else {
	            listChoChon.get(maChuyen).add(ve.getChoNgoi());
	        }
	    }

	    // Xử lý thông tin ga đi và ga đến từ chi tiết vé
	    for (ChiTietVe ctv : hoaDon.getListVes().get(0).getLisChiTietVes()) {
	        if (ctv.isChieu())
	            gaDi = ctv.getGa();
	        else
	            gaDen = ctv.getGa();
	    }

	    // Đặt chế độ một chiều
	    isMotChieu = true;

	    // Lấy các tuyến giữa ga đi và ga đến
	    List<String> listTuyens = new TuyenDao(emf).layTuyenChuaGa(gaDi.getId(), gaDen.getId());
	    List<Chuyen> listChuyenVes = new ArrayList<Chuyen>();
	    ngayDi = hoaDon.getListVes().get(0).getChuyen().getNgayKhoiHanh();
	    for (String maTuyen : listTuyens) {
	        List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngayDi, gaDi.getId() < gaDen.getId(), maTuyen);
	        listChuyenVes.addAll(listtam);
	    }
	    this.listChuyens = listChuyenVes;

	    // Cập nhật giao diện và dữ liệu liên quan
	    createModel_IfVes();
	    updateDataChuyen();
	    AddDataTau();
	}


	
	private void createModel_IfVes() {
		if (hoaDon == null)
			return;
		for (Ve ve : hoaDon.getListVes()) {
			Model_Tau modelTau = null;
			Ga gd = null;
			Ga gde = null;
			for (ChiTietVe ctv : ve.getLisChiTietVes()) {
				if (ctv.isChieu())
					gd = ctv.getGa();
				else
					gde = ctv.getGa();
			}
			if (gd.getId() < gde.getId())
				modelTau = new Model_Tau(ve.getChuyen(), gd, gde, gaDau);
			else
				modelTau = new Model_Tau(ve.getChuyen(), gd, gde, gaCuoi);
			Model_InfoVe veIf = new Model_InfoVe(modelTau, ve.getChoNgoi(), null);
			KhuyenMai km = ve.getKhuyenMai();
			int gia = (int) Math.round(ve.getChoNgoi().getGia() * Math.abs(gd.getId() - gde.getId()));
			model.addRow(new Object[] { ve.getKhachHang().getCccd(), ve.getKhachHang().getHoTen(),
					ve.getKhachHang().getDoiTuong(), veIf.toString(), gia,
					km == null ? 0 : gia * ve.getKhuyenMai().getChietKhau(),
					km == null ? gia : gia * (1 - km.getChietKhau()) });
			listInfoVes.add(veIf);
		}

	}

	
	private void XoaTrang() {
		listInfoVes.clear();
		listChoChon.clear();
		liscccd.clear();
		DefaultTableModel md = (DefaultTableModel) tbListVe.getModel();
		md.setRowCount(0);
		listTau.removeAll();
		jtCccd.setText("");
		jtHoT.setText("");
		jtSdt.setText("");
		jtEm.setText("");
	}

	private int checkDataVe(KhachHang khachHang) {
		if (!khachHang.getCccd().trim().matches("\\d{12}")) {
			return 1;
		}
		if (!khachHang.getHoTen().trim().matches("^[^!@#$%^&*()\\d]+$")) {
			return 2;
		}
		return 0;
	}

	private boolean checkTableData() {
	    for (int i = 0; i < model.getRowCount(); i++) {
	        // Lấy thông tin từ bảng
	        String cccd = model.getValueAt(i, 0).toString().trim();
	        String hoTen = model.getValueAt(i, 1).toString().trim();
	        String sdt = model.getValueAt(i, 3).toString().trim(); // Giả sử số điện thoại ở cột 3
	        String email = model.getValueAt(i, 4).toString().trim(); // Giả sử email ở cột 4

	        // Tạo đối tượng KhachHang để kiểm tra
	        KhachHang khachHang = new KhachHang(cccd, sdt, hoTen, email);

	        // Kiểm tra thông tin
	        int check = checkData(khachHang);
	        if (check != 0) {
	            // Chọn dòng lỗi và hiển thị thông báo
	            tbListVe.setRowSelectionInterval(i, i);
	            showMessageValue(check, "trong bảng");
	            return false; // Dừng kiểm tra khi có lỗi
	        }
	    }
	    return true; // Không có lỗi nào
	}
	
	private int checkData(KhachHang khachHang) {
	    String sdt = jtSdt.getText().trim();
	    if (!khachHang.getCccd().trim().matches("\\d{12}")) { // CCCD phải có 12 số
	        return 1;
	    }
	    if (!khachHang.getHoTen().trim().matches("^[^!@#$%^&*()\\d]+$")) { // Tên không chứa ký tự đặc biệt hoặc số
	        return 2;
	    }
	    if (!sdt.matches("^0[0-9]{9}$")) { // Số điện thoại phải bắt đầu bằng 0 và đủ 10 số
	        return 3;
	    }
	    if (!jtEm.getText().trim().matches("^[a-zA-Z0-9._%+-]+@(gmail|email)\\.com$")) { // Email đúng định dạng
	        return 4;
	    }
	    return 0; // Thông tin hợp lệ
	}

	
	private void tbListVeMouseClicked(MouseEvent evt) {// GEN-FIRST:event_tbListVeMouseClicked
		int index = tbListVe.getSelectedRow();
		if (index == -1)
			return;
		Model_InfoVe info = listInfoVes.get(index);
		lbTTCCCD.setText("CCCD: "+(String) tbListVe.getValueAt(index, 0));
		lbTTHoTen.setText("Họ tên: "+(String) tbListVe.getValueAt(index, 1));
		lbTauChuyen.setText(info.getThongTinChuyen());
		lbThoiGianLen.setText("Thời gian khởi hành: "+ info.getChuyen().getTGDi());
		lbToaCho.setText("Toa-Chỗ: "+info.getInfoCho());
		lbMoTaVe.setText("Mô tả vé: " + info.getcheckCho(info.getChoNgoi().getMoTa(), info.getChoNgoi().getViTri()));
	}// GEN-LAST:event_tbListVeMouseClicked

	
	private void btnHuyChoMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnHuyChoMouseClicked
		int index = tbListVe.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "chưa chọn vé cần hủy!");
			return;
		}

		Model_InfoVe infoVe = listInfoVes.get(index);
		if (infoVe.getItem() == null) {
			JOptionPane.showMessageDialog(null, "Vé đã thanh toán không được hủy!");
			return;
		}
		((ChoNgoiItem) infoVe.getItem()).setSelected(false);
		String maC = infoVe.getChuyen().getChuyen().getMaChuyen();
		if (listChoChon.containsKey(maC)) {
			listChoChon.get(maC).remove(infoVe.getChoNgoi());
		}
		listInfoVes.remove(index);
		model.removeRow(index);
		lbTauChuyen.setText(" ");
		lbThoiGianLen.setText(" ");
		lbToaCho.setText(" ");
		lbMoTaVe.setText(" ");
		lbTTCCCD.setText(" ");
		lbTTHoTen.setText(" ");
	}// GEN-LAST:event_btnHuyChoMouseClicked

	private void jrDiMouseClicked(MouseEvent evt) {// GEN-FIRST:event_jrDiMouseClicked
		if (isJrDi)
			return;
		isJrVe = !isJrVe;
		isJrDi = !isJrDi;
		List<String> listTuyens = new TuyenDao(emf).layTuyenChuaGa(gaDi.getId(), gaDen.getId());
		List<Chuyen> listChuyenVes = new ArrayList<Chuyen>();
		for (String maTuyen : listTuyens) {
			List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngayDi, gaDi.getId() > gaDen.getId(), maTuyen);
			listChuyenVes.addAll(listtam);
		}
		listTau.removeAll();
		Ga gatam1 = gaDi;
		Ga gatam2 = gaDen;
		this.gaDi = gatam2;
		this.gaDen = gatam1;
		this.listChuyens = listChuyenVes;
		AddDataTau();
		updateDataChuyen();
	}// GEN-LAST:event_jrDiMouseClicked

	private void jrVeActionPerformed(ActionEvent evt) {
		if (isJrVe)
			return;
		isJrVe = !isJrVe;
		isJrDi = !isJrDi;
		List<String> listTuyens = new TuyenDao(emf).layTuyenChuaGa(gaDi.getId(), gaDen.getId());
		List<Chuyen> listChuyenVes = new ArrayList<Chuyen>();
		for (String maTuyen : listTuyens) {
			List<Chuyen> listtam = new ChuyenDao(emf).getAllChuyenByNgay(ngayVe, gaDi.getId() > gaDen.getId(), maTuyen);
			listChuyenVes.addAll(listtam);
		}
		listTau.removeAll();
		Ga gatam1 = gaDi;
		Ga gatam2 = gaDen;
		this.gaDi = gatam2;
		this.gaDen = gatam1;
		this.listChuyens = listChuyenVes;
		AddDataTau();
		updateDataChuyen();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup btnGroup;
	private javax.swing.JButton btnHuyCho;
	private javax.swing.JButton btnTimChuyen;
	private javax.swing.JButton btnXacNhan;
	private javax.swing.JButton btnXuLyTreo;
	private com.toedter.calendar.JDateChooser dateDi;
	private com.toedter.calendar.JDateChooser dateVe;
	private component.FormIfToa formIfToa1;
	private component.FormTabelVe formTabelVe;
	private javax.swing.ButtonGroup groupDiVe;
	private JPanel jpChieu;
	private JPanel jpChucNang;
	private JPanel jpIfHanhKhach;
	private JPanel jpIfHanhTrinh;
	private JPanel jpIfToa;
	private JPanel jpIfve;
	private javax.swing.JRadioButton jrDi;
	private javax.swing.JRadioButton jrVe;
	private javax.swing.JTextField jtCccd;
	private javax.swing.JTextField jtEm;
	private javax.swing.JTextField jtGaDen;
	private javax.swing.JTextField jtGaDi;
	private javax.swing.JTextField jtHoT;
	private javax.swing.JTextField jtSdt;
	private JLabel lbGaDen;
	private JLabel lbGaDi;
	private JLabel lbGaDi1;
	private JLabel lbGaDi2;
	private JLabel lbGaDi3;
	private JLabel lbGaDi4;
	private JLabel lbMoTaVe;
	private JLabel lbNext;
	private JLabel lbNgayDi;
	private JLabel lbTauChuyen;
	private JLabel lbTTHoTen;
	private JLabel lbTTCCCD;
	private JLabel lbThoiGianLen;
	private JLabel lbToaCho;
	private JLabel lbVe;
	private JLabel lbifToa;
	private component.ListIconTau listIconTau;
	private component.ListTau listTau;
	private javax.swing.JRadioButton rdHoiKhu;
	private javax.swing.JRadioButton rdMotChieu;
	private JScrollPane scp;
	private JScrollPane scpTbVe;
	private JScrollPane spListKhoang;
	private javax.swing.JTable tbListVe;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblGhBn;
	private JPanel panel_2;
	private JLabel lblToaangChn;
}
